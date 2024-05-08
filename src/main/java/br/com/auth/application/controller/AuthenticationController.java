package br.com.auth.application.controller;

import br.com.auth.buildingblocks.dto.AuthenticationDto;
import br.com.auth.buildingblocks.dto.LoginResponseDto;
import br.com.auth.buildingblocks.dto.RegisterDto;
import br.com.auth.domain.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final IUserService userService;

    public AuthenticationController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticationDto authDto) {
        try {
            String token = userService.login(authDto);
            var responseObject = new LoginResponseDto(authDto.email(), token);
            return ResponseEntity.ok(responseObject);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("register")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterDto registerDto) {
        try {
            userService.register(registerDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
