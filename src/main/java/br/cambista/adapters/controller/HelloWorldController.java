package br.cambista.adapters.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<?> helloWorld(@RequestParam(name = "teste") String teste){
        return ResponseEntity.ok( "Hello World " + teste);
    }
}
