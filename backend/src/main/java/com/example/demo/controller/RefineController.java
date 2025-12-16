package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RefineService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RefineController {

    private final RefineService refineService;

    public RefineController(RefineService refineService) {
        this.refineService = refineService;
    }

    @PostMapping("/refine")
    public ResponseEntity<String> refine(@RequestBody String input) {
        if (input == null || input.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Input cannot be empty");
        }
        return ResponseEntity.ok(refineService.refineText(input));
    }
}
