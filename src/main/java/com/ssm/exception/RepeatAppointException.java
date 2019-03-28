package com.ssm.exception;

/**
 * Created by stm on 2018/3/17.
 */
/**
 * 重复预约异常
 */
public class RepeatAppointException extends RuntimeException {

    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }

}
