package com.example.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.exception.NotFoundException;
import com.example.music.model.MusicGenre;
import com.example.music.repository.MusicGenreRepository;

@Service
public class MusicGenreService {
    @Autowired
    MusicGenreRepository musicGenreRepository;

    public List<MusicGenre> findAll() {
        return musicGenreRepository.findAll();
    }

    public MusicGenre findById(Long id) throws NotFoundException {
        Optional<MusicGenre> findById = musicGenreRepository.findById(id);

        if (findById.isEmpty()) {
            throw new NotFoundException();
        }

        return findById.get();

    }
}
