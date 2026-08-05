package br.com.gustavo.userservice.service;

import br.com.gustavo.userservice.dto.request.UpdateUserRequest;
import br.com.gustavo.userservice.dto.response.UserResponse;
import br.com.gustavo.userservice.dto.request.CreateUserRequest;

import java.util.List;

public interface UserProfileService {

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse create(CreateUserRequest request);

    UserResponse update(Long id, UpdateUserRequest request);

    void delete(Long id);

}