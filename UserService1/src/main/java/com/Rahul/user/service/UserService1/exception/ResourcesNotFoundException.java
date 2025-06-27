package com.Rahul.user.service.UserService1.exception;

public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(){
        super("Resource Not Found on Server!!");
    }

    public  ResourcesNotFoundException(String message){
        super(message);
    }
}
