package br.com.auth.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class UserTestController {

    @GetMapping("userEndpoint")
    public ResponseEntity<String> getUserEndpoint() {
        return ResponseEntity.ok("Authenticated User");
    }

}
