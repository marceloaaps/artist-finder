package marceloproject.Spotifays.services;

import marceloproject.Spotifays.dtos.AlbumDTO;
import marceloproject.Spotifays.models.Album;
import marceloproject.Spotifays.models.Music;
import marceloproject.Spotifays.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing album-related operations.
 * Provides functionality to handle album insertion and retrieval by artist.
 */
@Service
public class AlbumService {

    @Autowired
    AlbumRepository repository;

    @Autowired
    MusicService musicService;

    public void insertAlbum(AlbumDTO albumDTO){
        List<Music> musicList = albumDTO.musicList();

        Album album = new Album();
        album.setAlbumName(albumDTO.name());
        album.setArtist(albumDTO.artist());
        album.addMusicListToAlbum(musicList);

        Album savedAlbum = repository.save(album);

        musicList.forEach(music -> musicService.saveMusicAlbum(music.getId(), savedAlbum));
    }

    public List<Album> findAlbumByArtist(Long id){
        List<Album> albums = repository.findAlbumsByArtistId(id);
        if(albums.isEmpty()){
            throw new IllegalArgumentException("Esse artista não possui nenhum álbum");
        }
        return repository.findAlbumsByArtistId(id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
