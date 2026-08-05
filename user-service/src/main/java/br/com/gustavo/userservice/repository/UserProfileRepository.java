package br.com.gustavo.userservice.repository;

import br.com.gustavo.userservice.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository
        extends JpaRepository<UserProfile,Long> {
}