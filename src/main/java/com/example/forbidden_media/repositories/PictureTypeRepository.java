package com.example.forbidden_media.repositories;

import com.example.forbidden_media.domain.entities.PictureTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureTypeRepository extends JpaRepository<PictureTypeEntity, Long> {
}
