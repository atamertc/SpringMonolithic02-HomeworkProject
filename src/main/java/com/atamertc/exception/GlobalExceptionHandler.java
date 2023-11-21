package com.atamertc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private ErrorMessage createErrorMessage(EErrorType type, Exception exception) {
        System.out.println("Hata olustu..." + exception.getMessage());
        return ErrorMessage.builder()
                .code(type.getCode())
                .status(type.getStatus())
                .message(type.getMessage())
                .build();
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body("Uygulamada bad request gerceklesti..." + e.getMessage());
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(UserNotFoundException e) {
        EErrorType eErrorType = e.getType();
        HttpStatus httpStatus = e.getType().getStatus();
        ErrorMessage errorMessage = createErrorMessage(eErrorType, e);
        errorMessage.setMessage(e.getMessage());
        return new ResponseEntity<ErrorMessage>(errorMessage, httpStatus);
    }
}
