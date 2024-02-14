package com.myblog.myblog11.exception;

public class ResourceNotFoundException extends RuntimeException{

    public  ResourceNotFoundException(String msg){
        super(msg);
    }
}
