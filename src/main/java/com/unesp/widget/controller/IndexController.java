package com.unesp.widget.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")

public class IndexController {

    @GetMapping(value = "/getId", produces = "application/json")
    public ResponseEntity getId() {
        return new ResponseEntity("Getando um ID", HttpStatus.OK);
    }

    @GetMapping(value = "/getNome", produces = "application/json")
    public ResponseEntity getNome() {
        return new ResponseEntity("Getando nome", HttpStatus.OK);
    }

    @GetMapping(value = "/getEnd", produces = "application/json")
    public ResponseEntity getEnd() {
        return new ResponseEntity("Getando um endereço", HttpStatus.OK);
    }
}
