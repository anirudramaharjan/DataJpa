package com.zorba.exception;

public class DataNotFound extends Exception{
	String msg;
	
	public DataNotFound(String msg) {
		super(msg);
	}

}
