package com.example.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.exception.NotFoundException;
import com.example.music.model.Music;
import com.example.music.repository.MusicRepository;

@Service
public class MusicService {

    @Autowired
    MusicRepository musicRepository;

    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    public Music findById(Long id) throws NotFoundException {
        Optional<Music> findById = musicRepository.findById(id);

        if (findById.isEmpty()) {
            throw new NotFoundException();
        }

        return findById.get();

    }

    public void createByEntity(Music music) {
        musicRepository.save(music);
    }

    public void updateByEntity(Music music) throws NotFoundException {

        Optional<Music> findById = musicRepository.findById(music.getId());

        if (findById.isEmpty()) {
            throw new NotFoundException();
        }

        Music musicToUpdate = findById.get();
        musicToUpdate.setMusicName(music.getMusicName());
        musicToUpdate.setMusicDurationSeconds(music.getMusicDurationSeconds());
        musicRepository.save(musicToUpdate);

    }

    public void deleteById(Long id) throws NotFoundException {
        Optional<Music> findById = musicRepository.findById(id);

        if (findById.isEmpty()) {
            throw new NotFoundException();
        }

        musicRepository.delete(findById.get());

    }

}
