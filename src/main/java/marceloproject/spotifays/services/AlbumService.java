package marceloproject.spotifays.services;

import marceloproject.spotifays.dtos.AlbumDTO;
import marceloproject.spotifays.models.Album;
import marceloproject.spotifays.models.Music;
import marceloproject.spotifays.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
