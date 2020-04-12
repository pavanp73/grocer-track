package com.pavan.track.exceptions;

public class CategoryNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1531337207340266909L;

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
