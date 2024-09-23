package com.comfortsoft.testcase.exceptions;

import java.io.FileNotFoundException;

public class ExcelFileNotFoundException extends RuntimeException {

    public ExcelFileNotFoundException(String message) {
        super(message);
    }
}
