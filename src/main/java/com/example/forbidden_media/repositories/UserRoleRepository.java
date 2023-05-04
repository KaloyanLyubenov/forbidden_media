package com.example.forbidden_media.repositories;

import com.example.forbidden_media.domain.entities.UserRoleEntity;
import com.example.forbidden_media.domain.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    Optional<UserRoleEntity> findUserRoleEntitiesByUserRole(UserRoleEnum userRole);

}
