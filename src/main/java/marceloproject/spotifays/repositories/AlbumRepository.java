package marceloproject.spotifays.repositories;

import marceloproject.spotifays.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findAlbumsByArtistId(Long artistId);

}
