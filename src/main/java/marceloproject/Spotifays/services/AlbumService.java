package marceloproject.Spotifays.services;

import marceloproject.Spotifays.dtos.AlbumDTO;
import marceloproject.Spotifays.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository repository;


    public void insertAlbum(AlbumDTO albumDTO){



    }
}
