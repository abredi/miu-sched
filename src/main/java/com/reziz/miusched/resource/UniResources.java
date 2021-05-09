package com.reziz.miusched.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/uni")
public class UniResources {
    @GetMapping
    private ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello from the University");
    }
}
