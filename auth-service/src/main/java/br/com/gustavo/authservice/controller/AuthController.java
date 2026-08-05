package br.com.gustavo.authservice.controller;

import br.com.gustavo.authservice.dto.request.LoginRequest;
import br.com.gustavo.authservice.dto.request.RegisterRequest;
import br.com.gustavo.authservice.dto.response.LoginResponse;
import br.com.gustavo.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){

        service.register(request);

        return ResponseEntity.ok("Usuário cadastrado com sucesso!");

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(service.login(request));

    }

}