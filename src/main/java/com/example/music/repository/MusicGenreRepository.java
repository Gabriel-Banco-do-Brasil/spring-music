package com.example.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.music.model.MusicGenre;

@Repository
public interface MusicGenreRepository extends JpaRepository<MusicGenre, Long>{
    
}
