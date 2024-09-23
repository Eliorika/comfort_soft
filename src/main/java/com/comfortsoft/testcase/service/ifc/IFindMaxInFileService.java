package com.comfortsoft.testcase.service.ifc;


import com.comfortsoft.testcase.exceptions.ExcelFileNotFoundException;
import com.comfortsoft.testcase.exceptions.ExcelIOException;

public interface IFindMaxInFileService {

    int findMaxInFile(String path, int n);
}
