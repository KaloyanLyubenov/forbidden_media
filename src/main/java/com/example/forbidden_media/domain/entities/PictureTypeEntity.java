package com.example.forbidden_media.domain.entities;

import com.example.forbidden_media.domain.enums.PictureTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "picture_types")
public class PictureTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PictureTypeEnum pictureType;

    public PictureTypeEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public PictureTypeEntity setPictureType(PictureTypeEnum pictureType) {
        this.pictureType = pictureType;
        return this;
    }
}
