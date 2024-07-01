package com.neurogine.assessment.exception;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 1:26:47 PM
 */
public class ResourceNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = 4154443103458418705L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}

