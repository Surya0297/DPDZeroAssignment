package com.DPDZero.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrorDetails {
	
	private String status="error";
	
	private LocalDateTime timeStamp;
	
	private String msg;
	
	private String details;
}