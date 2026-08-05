package br.com.gustavo.userservice.service.impl;

import br.com.gustavo.userservice.dto.request.UpdateUserRequest;
import br.com.gustavo.userservice.dto.response.UserResponse;
import br.com.gustavo.userservice.entity.UserProfile;
import br.com.gustavo.userservice.repository.UserProfileRepository;
import br.com.gustavo.userservice.service.UserProfileService;
import br.com.gustavo.userservice.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    @Override
    public List<UserResponse> findAll() {

        return repository.findAll().stream().map(this::toResponse).toList();

    }

    @Override
    public UserResponse findById(Long id) {

        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

    }

    @Override
    public UserResponse create(CreateUserRequest request) {

        UserProfile user = UserProfile.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .telefone(request.getTelefone())
                .endereco(request.getEndereco())
                .cidade(request.getCidade())
                .estado(request.getEstado())
                .cep(request.getCep())
                .build();

        return toResponse(repository.save(user));

    }

    @Override
    public UserResponse update(Long id, UpdateUserRequest request) {

        UserProfile user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        user.setNome(request.getNome());
        user.setTelefone(request.getTelefone());
        user.setEndereco(request.getEndereco());
        user.setCidade(request.getCidade());
        user.setEstado(request.getEstado());
        user.setCep(request.getCep());

        return toResponse(repository.save(user));

    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);

    }

    private UserResponse toResponse(UserProfile user){

        return UserResponse.builder()
                .id(user.getId())
                .nome(user.getNome())
                .email(user.getEmail())
                .telefone(user.getTelefone())
                .endereco(user.getEndereco())
                .cidade(user.getCidade())
                .estado(user.getEstado())
                .cep(user.getCep())
                .build();

    }

}