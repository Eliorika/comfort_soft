package com.comfortsoft.testcase.controller;


import com.comfortsoft.testcase.exceptions.ExcelFileNotFoundException;
import com.comfortsoft.testcase.exceptions.ExcelIOException;
import com.comfortsoft.testcase.service.ifc.IFindMaxInFileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/find")
public class FindMaxController {

    private final IFindMaxInFileService findMaxInFileService;

    public FindMaxController(IFindMaxInFileService findMaxInFileService) {
        this.findMaxInFileService = findMaxInFileService;
    }

    @GetMapping("/max")
    public ResponseEntity<Integer> findMax(@RequestParam(name = "path") String path, @RequestParam(name="n") int n){
        int res = findMaxInFileService.findMaxInFile(path, n);
        return ResponseEntity.ok(res);
    }

}
