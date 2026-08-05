package br.com.gustavo.authservice.service.impl;

import br.com.gustavo.authservice.dto.request.LoginRequest;
import br.com.gustavo.authservice.dto.request.RegisterRequest;
import br.com.gustavo.authservice.dto.response.LoginResponse;
import br.com.gustavo.authservice.entity.Role;
import br.com.gustavo.authservice.entity.User;
import br.com.gustavo.authservice.repository.UserRepository;
import br.com.gustavo.authservice.service.JwtService;
import br.com.gustavo.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest request){

        if(repository.existsByEmail(request.getEmail())){
            throw new RuntimeException("E-mail já cadastrado.");
        }

        User user = User.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .role(Role.ROLE_USER)
                .build();

        repository.save(user);

    }

    @Override
    public LoginResponse login(LoginRequest request){

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if(!passwordEncoder.matches(request.getSenha(),user.getSenha())){
            throw new RuntimeException("Senha inválida.");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token);

    }

}