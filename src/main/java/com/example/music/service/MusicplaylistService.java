package com.example.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.exception.NotFoundException;
import com.example.music.model.MusicPlaylist;
import com.example.music.repository.MusicPlaylistRepository;

@Service
public class MusicplaylistService {

    private static final int RESET_TO_ZERO = 0;
    @Autowired
    MusicPlaylistRepository musicPlaylistRepository;

    public List<MusicPlaylist> findAll() {
        return musicPlaylistRepository.findAll();
    }

    public MusicPlaylist findById(Long id) throws NotFoundException {
        Optional<MusicPlaylist> findById = musicPlaylistRepository.findById(id);

        if (findById.isEmpty()) {
            throw new NotFoundException();
        }

        return findById.get();

    }

    public void updateByEntity(MusicPlaylist musicPlaylist) throws NotFoundException {

        Optional<MusicPlaylist> findById = musicPlaylistRepository.findById(musicPlaylist.getId());

        if (findById.isEmpty()) {
            throw new NotFoundException();
        }

        MusicPlaylist musicPlaylistToUpdate = findById.get();
        musicPlaylistToUpdate.setMusicList(musicPlaylist.getMusicList());
        musicPlaylistToUpdate.setLikesCount(RESET_TO_ZERO);
        musicPlaylistToUpdate.setDislikesCount(RESET_TO_ZERO);
        musicPlaylistRepository.save(musicPlaylistToUpdate);

    }
    
}
