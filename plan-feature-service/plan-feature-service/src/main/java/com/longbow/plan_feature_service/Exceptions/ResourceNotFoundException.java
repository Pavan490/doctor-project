package com.longbow.plan_feature_service.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
		
	public ResourceNotFoundException(String message) {
        super(message);
    }
}
