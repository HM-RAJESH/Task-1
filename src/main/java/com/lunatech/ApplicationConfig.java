package com.lunatech;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.lunatech.demo.services.entity.TitleBasics;

import scala.collection.Iterator;
import scala.collection.mutable.WrappedArray;

/**
 * Created by achat1 on 9/22/15.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Autowired
    private Environment env;

    @Value("${app.name:LunatechDemo}")
    private String appName;

    @Value("${spark.home}")
    private String sparkHome;

    @Value("${master.uri:local}")
    private String masterUri;

    @Bean
    public SparkConf sparkConf() {
        SparkConf sparkConf = new SparkConf()
                .setAppName(appName)
                .setSparkHome(sparkHome)
                .setMaster(masterUri);

        return sparkConf;
    }

    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(sparkConf());
    }

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .sparkContext(javaSparkContext().sc())
                .appName(appName)
                .getOrCreate();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public JavaRDD<String> basicsRDD(){
    	JavaRDD<String> basicsRDD = sparkSession().read()
				  .textFile("./src/main/resources/title.basics.tsv")
				  .javaRDD();
    	return basicsRDD;
    }
    
    @Bean
    public JavaRDD<String> ratingsRDD(){
    	JavaRDD<String> ratingsRDD = sparkSession().read()
				  .textFile("./src/main/resources/title.ratings.tsv")
				  .javaRDD();
    	return ratingsRDD;
    }
}