package com.example.btracker.exception;

public class CustomException extends IllegalArgumentException {

    public CustomException(String message) {
        super(message);
    }
}