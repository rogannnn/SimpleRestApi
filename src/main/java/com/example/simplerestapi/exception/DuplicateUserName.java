package com.example.simplerestapi.exception;

public class DuplicateUserName extends Exception{
    public DuplicateUserName(String message) {
        super(message);
    }
}
