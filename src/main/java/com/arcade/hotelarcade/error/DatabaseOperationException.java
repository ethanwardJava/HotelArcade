package com.arcade.hotelarcade.error;

public class DatabaseOperationException extends RuntimeException {
    public DatabaseOperationException(String message , Throwable cause) {
        super(message , cause);
    }
}
