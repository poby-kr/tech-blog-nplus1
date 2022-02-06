package org.poby.techblog.product.exception;

public class NotEnoughStockQuantityException extends RuntimeException{

    public NotEnoughStockQuantityException(String message) {
        super(message);
    }
}
