package marceloproject.Spotifays.services;

import marceloproject.Spotifays.dtos.MusicDTO;
import marceloproject.Spotifays.models.Album;
import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.models.Music;
import marceloproject.Spotifays.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicService {

    @Autowired
    private MusicRepository repository;

    public void insertMusic(MusicDTO musicDTO){
        List<Artist> featuredList = musicDTO.featuredArtists();

        Music music = new Music();
        music.setName(musicDTO.name());
        music.setTimeDurantion(musicDTO.timeDuration());
        music.setMusicRating(musicDTO.musicRating());

        featuredList.stream().forEach(f -> music.addFeaturedArtist(featuredList));

        repository.save(music);

    }

    public List<Music> findMusicByName(String name){

        return repository.findByNameContainingOrderByIdAsc(name);

    }

    public void saveMusicAlbum(Long musicId, Album album) {
        Music music = repository.findById(musicId)
                .orElseThrow(() -> new IllegalArgumentException("Musica não encontrada: " + musicId));
        music.setAlbum(album);
        repository.save(music);
    }

    @Override
    public String toString() {
        return "MusicService{" +
                "repository=" + repository +
                '}';
    }
}
