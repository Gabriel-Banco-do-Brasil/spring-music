package com.example.music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "music")
public class Music {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String musicName;

    @Getter
    @Setter
    private Integer musicDurationSeconds;

    @Getter
    @Setter
    @ManyToOne
    private MusicGenre musicGenre;

    @Override
    public String toString() {
        return "Music [id=" + id +
                ", musicName=" + musicName +
                ", musicDurationSeconds=" + musicDurationSeconds +
                ", musicGenre=" + musicGenre +
                "]";
    }

}
