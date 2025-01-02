package marceloproject.Spotifays.repositories;

import marceloproject.Spotifays.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
