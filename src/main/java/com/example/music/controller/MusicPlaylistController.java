package com.example.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.exception.NotFoundException;
import com.example.music.model.MusicPlaylist;
import com.example.music.service.MusicplaylistService;

@RestController
@RequestMapping("/musicPlaylist")
public class MusicPlaylistController {

    @Autowired
    MusicplaylistService musicplaylistService;

    @GetMapping("/findAll")
    public ResponseEntity<List<MusicPlaylist>> findAll() {

        List<MusicPlaylist> returnedList = musicplaylistService.findAll();
        return ResponseEntity.ok(returnedList);

    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<MusicPlaylist> findById(@PathVariable Long id) {

        try {
            MusicPlaylist returnedMusicPlaylist = musicplaylistService.findById(id);
            return ResponseEntity.ok(returnedMusicPlaylist);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/updateByEntity")
    public ResponseEntity<MusicPlaylist> updateByEntity(@RequestBody MusicPlaylist musicPlaylist) {

        try {
            musicplaylistService.updateByEntity(musicPlaylist);
            return ResponseEntity.ok(musicPlaylist);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
