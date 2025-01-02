package marceloproject.Spotifays.repositories;

import marceloproject.Spotifays.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
