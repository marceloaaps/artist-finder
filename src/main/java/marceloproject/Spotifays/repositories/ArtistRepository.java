package marceloproject.Spotifays.repositories;

import jakarta.persistence.Tuple;
import marceloproject.Spotifays.models.Album;
import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findAllByOrderByIdAsc();

    @Query("SELECT a.id, a.name FROM Artist a WHERE a.name LIKE CONCAT(:name, '%')")
    List<Tuple> findArtistByName(String name);

    Optional<Artist> findById(Long aLong);



}
