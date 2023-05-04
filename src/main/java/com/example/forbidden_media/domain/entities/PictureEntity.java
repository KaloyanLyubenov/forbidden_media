package com.example.forbidden_media.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "pictures")
public class PictureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    private PictureTypeEntity pictureType;

    public PictureEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public PictureEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public PictureEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public PictureEntity setPictureType(PictureTypeEntity pictureType) {
        this.pictureType = pictureType;
        return this;
    }
}
