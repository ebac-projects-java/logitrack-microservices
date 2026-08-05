package br.com.gustavo.authservice.service.impl;

import br.com.gustavo.authservice.dto.request.LoginRequest;
import br.com.gustavo.authservice.dto.response.LoginResponse;
import br.com.gustavo.authservice.entity.Role;
import br.com.gustavo.authservice.entity.User;
import br.com.gustavo.authservice.repository.UserRepository;
import br.com.gustavo.authservice.service.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private UserServiceImpl service;

    @Test
    void deveRealizarLoginComSucesso() {

        LoginRequest request = new LoginRequest();

        request.setEmail("gustavo@email.com");
        request.setSenha("123456");

        User user = User.builder()
                .id(1L)
                .nome("Gustavo")
                .email("gustavo@email.com")
                .senha("senhaCriptografada")
                .role(Role.ROLE_USER)
                .build();

        when(repository.findByEmail("gustavo@email.com"))
                .thenReturn(Optional.of(user));

        when(passwordEncoder.matches("123456", "senhaCriptografada"))
                .thenReturn(true);

        when(jwtService.generateToken("gustavo@email.com"))
                .thenReturn("jwt-token-teste");

        LoginResponse response = service.login(request);

        assertNotNull(response);
        assertEquals("jwt-token-teste", response.getToken());

        verify(repository).findByEmail("gustavo@email.com");
        verify(passwordEncoder).matches("123456", "senhaCriptografada");
        verify(jwtService).generateToken("gustavo@email.com");
    }

}