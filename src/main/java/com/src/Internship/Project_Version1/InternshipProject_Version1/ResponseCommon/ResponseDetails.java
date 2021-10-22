package com.src.Internship.Project_Version1.InternshipProject_Version1.ResponseCommon;

public class ResponseDetails {
	
	private int code;
	
	private String time;
	
	private String message;

	public ResponseDetails() {
	}

	public ResponseDetails(int code, String time, String message) {
		this.code = code;
		this.time = time;
		this.message = message;
	}

	public int getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
