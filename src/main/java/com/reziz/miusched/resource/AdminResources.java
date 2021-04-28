package com.reziz.miusched.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin")
@RequiredArgsConstructor
public class AdminResources {
    @GetMapping
    private ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello from the Admin");
    }

    @GetMapping("/add")
    private ResponseEntity<String> get() {
        return ResponseEntity.ok("yaay");
    }
}
