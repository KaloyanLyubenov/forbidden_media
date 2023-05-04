package com.example.forbidden_media.services;

import com.example.forbidden_media.domain.binding.models.PictureTypeModel;
import com.example.forbidden_media.domain.binding.models.UserRoleModel;
import com.example.forbidden_media.domain.entities.PictureTypeEntity;
import com.example.forbidden_media.domain.entities.UserEntity;
import com.example.forbidden_media.domain.entities.UserRoleEntity;
import com.example.forbidden_media.domain.enums.PictureTypeEnum;
import com.example.forbidden_media.domain.enums.UserRoleEnum;
import com.example.forbidden_media.repositories.PictureTypeRepository;
import com.example.forbidden_media.repositories.UserRepository;
import com.example.forbidden_media.repositories.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InitService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PictureTypeRepository pictureTypeRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public InitService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PictureTypeRepository pictureTypeRepository, PasswordEncoder passwordEncoder,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.pictureTypeRepository = pictureTypeRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        initRoles();
        initUsers();
        initPictureTypes();
    }

    private void initRoles() {
        if(this.userRoleRepository.count() == 0){
            this.userRoleRepository.saveAllAndFlush((Arrays.stream(UserRoleEnum.values()))
                    .map(enumValue -> new UserRoleModel().setUserRole(enumValue))
                    .map(userRoleModel -> this.modelMapper.map(userRoleModel, UserRoleEntity.class))
                    .toList());
        }
    }

    private void initPictureTypes() {
        if(this.pictureTypeRepository.count() == 0){
            this.pictureTypeRepository.saveAllAndFlush((Arrays.stream(PictureTypeEnum.values()))
                    .map(enumValue -> new PictureTypeModel().setPictureType(enumValue))
                    .map(pictureTypeModel -> this.modelMapper.map(pictureTypeModel, PictureTypeEntity.class))
                    .toList());
        }
    }

    private void initUsers(){
        if(userRepository.count() == 0){
            initAdmin();
            initModerator();
        }
    }

    private void initAdmin(){
        var adminUser = new UserEntity()
                .setUsername("admin")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setUserRoles(userRoleRepository.findAll());

        userRepository.save(adminUser);
    }

    private void initModerator(){
        var moderatorRole = userRoleRepository.
                findUserRoleEntitiesByUserRole(UserRoleEnum.Moderator).orElseThrow();

        var moderatorUser = new UserEntity()
                .setUsername("moderator")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setUserRoles(List.of(moderatorRole));

        userRepository.save(moderatorUser);
    }

}
