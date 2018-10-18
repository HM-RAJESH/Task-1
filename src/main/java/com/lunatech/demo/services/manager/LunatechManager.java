package com.lunatech.demo.services.manager;

import java.io.Serializable;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lunatech.demo.exception.FilmException;
import com.lunatech.demo.services.entity.TopRatedMovie;


@Service
public interface LunatechManager extends Serializable {
		
	List<TopRatedMovie> getTopRatedFilms(String genretype) throws FilmException;
}
