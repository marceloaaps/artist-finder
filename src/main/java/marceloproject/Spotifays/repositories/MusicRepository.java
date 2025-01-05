package marceloproject.Spotifays.repositories;

import marceloproject.Spotifays.models.Album;
import marceloproject.Spotifays.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {


    List<Music> findByNameContainingOrderByIdAsc(String name);


}
