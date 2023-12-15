package com.test.kipaskipas.customexception;


public class CustomProductException extends RuntimeException {

    public CustomProductException() {
        super();
    }

    public CustomProductException(String message) {
        super(message);
    }

    public CustomProductException(String message, Throwable cause) {
        super(message, cause);
    }
}


