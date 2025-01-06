package marceloproject.Spotifays.services;

import marceloproject.Spotifays.dtos.AlbumDTO;
import marceloproject.Spotifays.models.Album;
import marceloproject.Spotifays.models.Music;
import marceloproject.Spotifays.repositories.AlbumRepository;
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
        return repository.findAlbumsByArtistId(id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
