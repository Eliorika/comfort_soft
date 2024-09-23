package com.comfortsoft.testcase.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler{

    protected Map<String, Object> getBody(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("message", ex.getMessage());
        return body;
    }

    @ExceptionHandler({ExcelFileNotFoundException.class})
    protected ResponseEntity<Object> handleExcelFileNotFound(Exception ex) {
        return new ResponseEntity(getBody(ex), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ExcelIOException.class})
    protected ResponseEntity<Object> handleExcelIOException(Exception ex) {
        return new ResponseEntity(getBody(ex), HttpStatus.BAD_REQUEST);
    }
}
