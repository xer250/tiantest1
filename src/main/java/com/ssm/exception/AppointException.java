package com.ssm.exception;

/**
 * Created by stm on 2018/3/17.
 */
public class AppointException extends RuntimeException {

    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }

}
