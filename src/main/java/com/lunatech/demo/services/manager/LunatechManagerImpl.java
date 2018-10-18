package com.lunatech.demo.services.manager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunatech.demo.exception.FilmException;
import com.lunatech.demo.services.entity.TitleBasics;
import com.lunatech.demo.services.entity.TitleRatings;
import com.lunatech.demo.services.entity.TopRatedMovie;

import scala.collection.Iterator;
import scala.collection.mutable.WrappedArray;

@Service
public class LunatechManagerImpl implements LunatechManager {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SparkSession sparkSession;

	@Autowired
	private JavaRDD<String> basicsRDD;

	@Autowired
	private JavaRDD<String> ratingsRDD;

	@Override
	public List<TopRatedMovie> getTopRatedFilms(String genretype) throws FilmException{
		
		String myGenretype = genretype!=null?genretype.trim():"";
		
		JavaRDD<TitleBasics> basicsTitleRDD = getBasicsTitleRDD();
		
		JavaRDD<TitleRatings> ratingsTitleRDD = getRatingsTitleRDD();
		
		Dataset<Row> basicsTitleDF = sparkSession.createDataFrame(basicsTitleRDD, TitleBasics.class);
		/*basicsDF.printSchema();*/
		
		Dataset<Row> ratingsTitleDF = sparkSession.createDataFrame(ratingsTitleRDD, TitleRatings.class);
		
		Dataset<Row> TopRatedDS = basicsTitleDF.join(ratingsTitleDF,"tconst");
		/*TopRatedDS.printSchema();*/
		TopRatedDS.show();
			
		List<TopRatedMovie> topRatedMovieList = TopRatedDS.toJavaRDD().map((row)-> {
			 return new TopRatedMovie(row.getString(4),
					 convert((WrappedArray<String>)row.get(2))
					 ,row.getDouble(9));
	        
	    }).collect();
		
		return topRatedMovieList.stream().filter(data->Arrays.asList(data.getGenres()).contains(myGenretype)).collect(Collectors.toList());
	}

	private JavaRDD<TitleBasics> getBasicsTitleRDD() {
		return basicsRDD.map(line -> {
			String[] parts = line.split("\t");
			TitleBasics titlebasics = new TitleBasics();
			titlebasics.setTconst(checkColumn(parts[0]));
			titlebasics.setTitleType(checkColumn(parts[1]));
			titlebasics.setPrimaryTitle(checkColumn(parts[2]));
			titlebasics.setOriginalTitle(checkColumn(parts[3]));
			if (checkColumn(parts[4]) != null)
				titlebasics.setIsAdult(0 == Integer.parseInt(checkColumn(parts[4])) ? false : true);
			titlebasics.setStartYear(checkColumn(parts[5]));
			titlebasics.setEndYear(checkColumn(parts[6]));
			if (checkColumn(parts[7]) != null)
				titlebasics.setRuntimeMinutes(Integer.parseInt(checkColumn(parts[7])));
			titlebasics.setGenres(checkColumn(parts[8]).split(","));
			return titlebasics;
		});
	}

	private JavaRDD<TitleRatings> getRatingsTitleRDD() {
		return ratingsRDD.map(line -> {
			String[] parts = line.split("\t");
			TitleRatings titleRatings = new TitleRatings();
			titleRatings.setTconst(checkColumn(parts[0]));
			if (checkColumn(parts[1]) != null)
				titleRatings.setAverageRating(Double.parseDouble(checkColumn(parts[1])));
			if (checkColumn(parts[2]) != null)
				titleRatings.setNumVotes(Integer.parseInt(checkColumn(parts[2])));
			return titleRatings;
		});
	}

	private String checkColumn(String col) {
		return ("\\N".equalsIgnoreCase(col) ? null : col);
	}

	private String[] convert(WrappedArray<String> array) {
		WrappedArray<String> wArray = array;
		String[] convertedString = new String[wArray.size()];
		Iterator<String> wItr = wArray.iterator();
		int i = 0;
		while (wItr.hasNext()) {
			convertedString[i] = wItr.next();
			i++;
		}
		return convertedString;
	}
}
