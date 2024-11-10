package com.talkyteck.accounts.exceptions;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String msg1,String msg2,String msg3) {
        super(String.format("%s has not available for the %s %s",msg1,msg2,msg3));
    }
}
