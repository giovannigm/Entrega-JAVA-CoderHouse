package com.PreEntrega1.testJPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.PreEntrega1.testJPA.Cabania;
import com.PreEntrega1.testJPA.service.CabaniaService;

@RestController
@RequestMapping("/Cabania")
public class CabaniaController {

    @Autowired
    private CabaniaService cabaniaService;

    @GetMapping("/all")
    // API: http://localhost:8080/Cabania/all
    public ResponseEntity<List<Cabania>> getAllCabanias() {
        try {
            List<Cabania> cabanias = cabaniaService.findAll();
            return ResponseEntity.ok(cabanias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e) {
        return e.getMessage();
    }

}
