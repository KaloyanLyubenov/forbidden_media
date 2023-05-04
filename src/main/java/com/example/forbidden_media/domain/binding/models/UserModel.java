package com.example.forbidden_media.domain.binding.models;

import com.example.forbidden_media.domain.entities.UserEntity;
import com.example.forbidden_media.domain.entities.UserRoleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserModel {

    private Long id;

    private String username;

    private String password;

    private List<UserRoleModel> userRoles;

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserModel setUserRoles(List<UserRoleModel> userRoles) {
        this.userRoles = userRoles;
        return this;
    }
}
