package com.example.casino.entity;
public class GenericResponse {
	private String message;
	public GenericResponse(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}