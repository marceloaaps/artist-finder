package marceloproject.Spotifays.services;

import marceloproject.Spotifays.dtos.MusicDTO;
import marceloproject.Spotifays.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {

    @Autowired
    private MusicRepository repository;

    public void insertMusic(MusicDTO musicDTO){


    }


}
