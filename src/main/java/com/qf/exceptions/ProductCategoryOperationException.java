package com.qf.exceptions;

public class ProductCategoryOperationException extends RuntimeException{

    private static final long serialVersionUID = 2361446884833398905L;
    public ProductCategoryOperationException(String msg){
       super(msg);
    }
}
