package com.example.forbidden_media.domain.binding.models;

import com.example.forbidden_media.domain.enums.UserRoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleModel {

    private Long id;

    private UserRoleEnum userRole;

    public UserRoleModel setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRoleModel setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }
}
