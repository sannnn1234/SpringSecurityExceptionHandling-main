package com.springsecurityexceptionhandling.customException;

import org.springframework.stereotype.Component;

@Component
public class EmptyInputException extends RuntimeException{

    private static final long  serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;

    public EmptyInputException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public EmptyInputException() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
