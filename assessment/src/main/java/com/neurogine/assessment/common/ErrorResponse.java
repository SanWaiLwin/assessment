package com.neurogine.assessment.common;

import java.io.Serializable;

import lombok.Data;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 1:02:23 PM
 */
@Data
public class ErrorResponse implements Serializable{
	
	private static final long serialVersionUID = 4609186651592841474L;
	
	private String message;
    private int status;
    
    
    public ErrorResponse() {
		super(); 
	}
    
	public ErrorResponse(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	} 
}
