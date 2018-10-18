package com.lunatech.demo.exception;

public class FilmException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	FilmException(String exception){
		super(exception);
	}
}
