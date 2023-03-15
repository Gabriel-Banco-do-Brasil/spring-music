package com.example.music.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "musicGenre")
public class MusicGenre {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String genreName;

    @Getter
    @Setter
    private String genreType;

    @Override
    public String toString() {
        return "MusicGenre [id=" + id +
                ", genreName=" + genreName +
                ", genreType=" + genreType + "]";
    }

}
