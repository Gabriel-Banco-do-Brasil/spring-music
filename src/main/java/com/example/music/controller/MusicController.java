package com.example.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.exception.NotFoundException;
import com.example.music.model.Music;
import com.example.music.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    MusicService musicService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Music>> findAll() {

        List<Music> returnedList = musicService.findAll();
        return ResponseEntity.ok(returnedList);

    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Music> findById(@PathVariable Long id) {

        try {
            Music returnedMusic = musicService.findById(id);
            return ResponseEntity.ok(returnedMusic);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/createByEntity")
    public ResponseEntity<Music> createByEntity(@RequestBody Music music) {

        musicService.createByEntity(music);
        return ResponseEntity.ok(music);

    }

    @PutMapping("/updateByEntity")
    public ResponseEntity<Music> updateByEntity(@RequestBody Music music) {

        try {
            musicService.updateByEntity(music);
            return ResponseEntity.ok(music);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {

        try {
            musicService.deleteById(id);
            return ResponseEntity.ok(id);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
