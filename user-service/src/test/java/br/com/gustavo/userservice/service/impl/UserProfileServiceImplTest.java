package br.com.gustavo.userservice.service.impl;

import br.com.gustavo.userservice.dto.request.CreateUserRequest;
import br.com.gustavo.userservice.dto.response.UserResponse;
import br.com.gustavo.userservice.entity.UserProfile;
import br.com.gustavo.userservice.repository.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceImplTest {

    @Mock
    private UserProfileRepository repository;

    @InjectMocks
    private UserProfileServiceImpl service;

    @Test
    void deveCriarUsuarioComSucesso() {

        CreateUserRequest request = new CreateUserRequest();

        request.setNome("Gustavo Lima");
        request.setEmail("gustavo@email.com");
        request.setTelefone("11999999999");
        request.setEndereco("Rua A");
        request.setCidade("São Paulo");
        request.setEstado("SP");
        request.setCep("01234-567");

        UserProfile user = UserProfile.builder()
                .id(1L)
                .nome("Gustavo Lima")
                .email("gustavo@email.com")
                .telefone("11999999999")
                .endereco("Rua A")
                .cidade("São Paulo")
                .estado("SP")
                .cep("01234-567")
                .build();

        when(repository.save(any(UserProfile.class))).thenReturn(user);

        UserResponse response = service.create(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Gustavo Lima", response.getNome());
        assertEquals("gustavo@email.com", response.getEmail());

        verify(repository, times(1)).save(any(UserProfile.class));
    }

}