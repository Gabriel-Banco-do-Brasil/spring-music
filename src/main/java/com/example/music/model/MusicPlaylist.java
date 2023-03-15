package com.example.music.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "musicPlaylist")
public class MusicPlaylist {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToMany
    private List<Music> musicList;

    @Getter
    @Setter
    @Column(name = "like_count")
    private Integer likesCount;

    @Getter
    @Setter
    @Column(name = "dislike_count")
    private Integer dislikesCount;

    @Getter
    @Formula("CASE WHEN (like_count + dislike_count) = 0 THEN 0.5 ELSE like_count / (like_count + dislike_count * 1.0) END")
    public Double score;

    @Override
    public String toString() {
        return "MusicPlaylist [id=" + id +
                ", musicList=" + musicList +
                ", likesCount=" + likesCount +
                ", dislikesCount=" + dislikesCount +
                ", score=" + score +
                "]";
    }

}
