package com.reziz.miusched.resource;

import com.reziz.miusched.HelloRepository;
import com.reziz.miusched.model.Hello;
import com.reziz.miusched.model.dto.HelloDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hello")
public class HelloResource {

    private final HelloRepository helloRepository;

    public HelloResource(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @PostMapping
    public ResponseEntity<Hello> save(@RequestBody HelloDto hello) {
        var persistData = new Hello();
        persistData.setGreeting(hello.getGreeting());
        return ResponseEntity.ok(helloRepository.save(persistData));
    }

    @GetMapping
    public ResponseEntity<List<Hello>> getAll() {
        return ResponseEntity.ok(helloRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Hello> detail(@PathVariable Long id) {
        Optional<Hello> hello = helloRepository.findById(id);
        return hello.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Hello> get(@PathVariable Long id) {
        Optional<Hello> h = helloRepository.findById(id);
        return h.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Hello> update(@PathVariable Long id, @RequestBody HelloDto updatedObj) {
        Optional<Hello> h = helloRepository.findById(id);
        return h.map(hello -> {
                    hello.setGreeting(updatedObj.getGreeting());
                    helloRepository.save(hello);
                    return ResponseEntity.accepted().body(hello);
                }
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
