package br.com.gustavo.authservice.service;

import br.com.gustavo.authservice.dto.request.LoginRequest;
import br.com.gustavo.authservice.dto.request.RegisterRequest;
import br.com.gustavo.authservice.dto.response.LoginResponse;

public interface UserService {

    void register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}