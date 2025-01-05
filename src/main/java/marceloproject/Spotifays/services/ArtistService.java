package marceloproject.Spotifays.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Tuple;
import marceloproject.Spotifays.dtos.ArtistDTO;
import marceloproject.Spotifays.models.Album;
import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.models.Music;
import marceloproject.Spotifays.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Tuple> findArtistByName(String name){
        List<Tuple> artists = repository.findArtistByName(name);
        if (artists.isEmpty()) {
            throw new EntityNotFoundException("Artista não encontrado com o nome: " + name);
        }
        return artists;
    }

    public Artist findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Artist not found with ID: " + id));
    }

    public List<Artist> findAll(){
        return repository.findAllByOrderByIdAsc();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
