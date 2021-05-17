package com.tecnocampus.GSI.application.exception;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException(String id)  {
        super("Product " + id + " does not exist");
    }
}
