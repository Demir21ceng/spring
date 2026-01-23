package com.mycompany.todowithspring1.Exception;

public class NotFoundException extends RuntimeException{
    public  NotFoundException(String message){
        super(message);
    }
}
