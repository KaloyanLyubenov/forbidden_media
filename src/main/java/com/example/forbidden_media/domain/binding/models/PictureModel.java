package com.example.forbidden_media.domain.binding.models;

import com.example.forbidden_media.domain.entities.PictureTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PictureModel {

    private Long id;

    private String title;

    private String url;

    private PictureTypeModel pictureType;

    public PictureModel setId(Long id) {
        this.id = id;
        return this;
    }

    public PictureModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public PictureModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public PictureModel setPictureType(PictureTypeModel pictureType) {
        this.pictureType = pictureType;
        return this;
    }
}


