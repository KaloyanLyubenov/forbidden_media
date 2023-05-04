package com.example.forbidden_media.repositories;

import com.example.forbidden_media.domain.entities.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<PictureEntity, Long> {
}
