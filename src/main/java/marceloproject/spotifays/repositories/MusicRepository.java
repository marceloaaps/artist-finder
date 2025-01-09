package marceloproject.spotifays.repositories;

import marceloproject.spotifays.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {


    List<Music> findByNameContainingOrderByIdAsc(String name);


}
