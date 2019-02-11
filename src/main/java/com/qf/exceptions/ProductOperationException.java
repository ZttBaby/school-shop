package com.qf.exceptions;

public class ProductOperationException extends RuntimeException{

    private static final long serialVersionUID = 2361446884844498905L;

    public ProductOperationException(String msg){
       super(msg);
    }
}
