package com.example.music.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.music.model.Customer;
import com.example.music.model.Music;
import com.example.music.model.MusicGenre;
import com.example.music.model.MusicPlaylist;
import com.example.music.repository.CustomerRepository;
import com.example.music.repository.MusicGenreRepository;
import com.example.music.repository.MusicPlaylistRepository;
import com.example.music.repository.MusicRepository;

@Configuration
public class RepositoryConfig {

    @Autowired
    MusicRepository musicRepository;

    @Autowired
    MusicGenreRepository musicGenreRepository;

    @Autowired
    MusicPlaylistRepository musicPlaylistRepository;

    @Autowired
    CustomerRepository customerRepository;


    @PostConstruct
    public void initDB() {


        MusicGenre musicGenre1 = new MusicGenre();
        musicGenre1.setGenreName("Grunge");
        musicGenre1.setGenreType("Rock");
        musicGenreRepository.save(musicGenre1);

        MusicGenre musicGenre2 = new MusicGenre();
        musicGenre2.setGenreName("Europop");
        musicGenre2.setGenreType("Pop");
        musicGenreRepository.save(musicGenre2);
        
        MusicGenre musicGenre3 = new MusicGenre();
        musicGenre3.setGenreName("Death 'n' roll");
        musicGenre3.setGenreType("Metal");
        musicGenreRepository.save(musicGenre3);




        Music music1 = new Music();
        music1.setMusicName("Trees");
        music1.setMusicDurationSeconds(221);
        music1.setMusicGenre(musicGenre1);
        musicRepository.save(music1);

        Music music2 = new Music();
        music2.setMusicName("Torches");
        music2.setMusicDurationSeconds(220);
        music2.setMusicGenre(musicGenre2);
        musicRepository.save(music2);

        Music music3 = new Music();
        music3.setMusicName("Torches");
        music3.setMusicDurationSeconds(312);
        music3.setMusicGenre(musicGenre3);
        musicRepository.save(music3);



        
        MusicPlaylist musicPlaylist1 = new MusicPlaylist();
        musicPlaylist1.setMusicList(new ArrayList<Music>(List.of(music1, music2)));
        musicPlaylist1.setLikesCount(10);
        musicPlaylist1.setDislikesCount(2);
        musicPlaylistRepository.save(musicPlaylist1);

        MusicPlaylist musicPlaylist2 = new MusicPlaylist();
        musicPlaylist2.setMusicList(new ArrayList<Music>(List.of(music1, music3)));
        musicPlaylist2.setLikesCount(5);
        musicPlaylist2.setDislikesCount(4);
        musicPlaylistRepository.save(musicPlaylist2);
        
        MusicPlaylist musicPlaylist3 = new MusicPlaylist();
        musicPlaylist3.setMusicList(new ArrayList<Music>(List.of(music2, music3)));
        musicPlaylist3.setLikesCount(2);
        musicPlaylist3.setDislikesCount(6);
        musicPlaylistRepository.save(musicPlaylist3);





        Customer customer1 = new Customer();
        customer1.setName("Gabriel");
        customer1.setAge(22);
        customer1.setPlaylist(new ArrayList<MusicPlaylist>(List.of(musicPlaylist1)));
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Carlos");
        customer2.setAge(27);
        customer2.setPlaylist(new ArrayList<MusicPlaylist>(List.of(musicPlaylist2, musicPlaylist3)));
        customerRepository.save(customer2);
        
        Customer customer3 = new Customer();
        customer3.setName("Eduardo");
        customer3.setAge(33);
        customer3.setPlaylist(new ArrayList<MusicPlaylist>(List.of()));
        customerRepository.save(customer3);

    }

}
