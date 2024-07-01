package com.neurogine.assessment.exception;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 1, 2024 1:27:17 AM
 */
public class EntityNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = 3884866590230757791L;

	public EntityNotFoundException(String message) {
        super(message);
    }
}
