package com.example.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.exception.NotFoundException;
import com.example.music.model.MusicGenre;
import com.example.music.service.MusicGenreService;

@RestController
@RequestMapping("/musicGenre")
public class MusicGenreController {
    @Autowired
    MusicGenreService musicGenreService;

    @GetMapping("/findAll")
    public ResponseEntity<List<MusicGenre>> findAll() {

        List<MusicGenre> returnedList = musicGenreService.findAll();
        return ResponseEntity.ok(returnedList);

    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<MusicGenre> findById(@PathVariable Long id) {

        try {
            MusicGenre returnedMusic = musicGenreService.findById(id);
            return ResponseEntity.ok(returnedMusic);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
