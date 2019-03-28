package com.ssm.exception;

/**
 * Created by stm on 2018/3/17.
 */
public class NoNumberException extends RuntimeException {

    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }

}
