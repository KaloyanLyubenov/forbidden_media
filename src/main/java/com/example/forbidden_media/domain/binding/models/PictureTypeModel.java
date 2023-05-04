package com.example.forbidden_media.domain.binding.models;

import com.example.forbidden_media.domain.enums.PictureTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PictureTypeModel {

    private Long id;

    private PictureTypeEnum pictureType;

    public PictureTypeModel setId(Long id) {
        this.id = id;
        return this;
    }

    public PictureTypeModel setPictureType(PictureTypeEnum pictureType) {
        this.pictureType = pictureType;
        return this;
    }
}
