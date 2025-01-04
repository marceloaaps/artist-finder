package marceloproject.Spotifays.services;

import marceloproject.Spotifays.dtos.MusicDTO;
import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.models.Music;
import marceloproject.Spotifays.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository repository;

    public void insertMusic(MusicDTO musicDTO){
        List<Artist> featuredList = musicDTO.featuredArtists();

        Music music = new Music();
        music.setMusicName(musicDTO.name());
        music.setTimeDurantion(musicDTO.timeDuration());
        music.setMusicRating(musicDTO.musicRating());

        featuredList.stream().forEach(f -> music.addFeaturedArtist(featuredList));

        repository.save(music);

    }


}