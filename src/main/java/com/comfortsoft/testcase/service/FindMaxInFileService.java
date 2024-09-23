package com.comfortsoft.testcase.service;

import com.comfortsoft.testcase.exceptions.ExcelFileNotFoundException;
import com.comfortsoft.testcase.exceptions.ExcelIOException;
import com.comfortsoft.testcase.service.ifc.IFindMaxInFileService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.poi.ss.usermodel.*;

@Service
public class FindMaxInFileService implements IFindMaxInFileService {

    @Override
    public int findMaxInFile(String path, int n) {
        FileInputStream file = null;
        Queue<Integer> minHeap = new PriorityQueue<>(n);
        try {
            file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);



            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    int value = (int) cell.getNumericCellValue();

                    if (minHeap.size() < n) {
                        minHeap.offer(value);
                    } else if (value > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(value);
                    }
                }
            }

            workbook.close();
            file.close();


        } catch (FileNotFoundException e) {
            throw new ExcelFileNotFoundException("File with path " + path + " was not found");
        } catch (IOException e) {
            throw new ExcelIOException("Problem reading the file " + path);
        }

        return minHeap.peek();
    }
}
