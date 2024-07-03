package com.neurogine.assessment.exception;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 3, 2024 11:04:26 AM
 */
public class UnauthorizedException extends RuntimeException {
	
    private static final long serialVersionUID = 4154443103458418705L;

	public UnauthorizedException(String message) {
        super(message);
    }
}
