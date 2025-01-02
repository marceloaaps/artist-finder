package marceloproject.Spotifays.services;

import marceloproject.Spotifays.dtos.ArtistDTO;
import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository repository;


    public ArtistService(){
    }

    public void insertArtist(ArtistDTO artistDTO){
        Artist artist = new Artist();
        artist.setName(artistDTO.name());
        artist.setCountryWasBorn(artistDTO.countryWasBorn());
        artist.setAge(artistDTO.age());
        artist.setBiography(artistDTO.biography());
        artist.setArtistType(artistDTO.artistType());

        repository.save(artist);
    }
}
