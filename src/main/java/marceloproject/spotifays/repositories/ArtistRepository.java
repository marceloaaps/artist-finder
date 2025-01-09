package marceloproject.spotifays.repositories;

import jakarta.persistence.Tuple;
import marceloproject.spotifays.models.Artist;
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


    @Override
    Optional<Artist> findById(Long aLong);



}
