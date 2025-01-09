package marceloproject.spotifays.dtos;

import marceloproject.spotifays.models.Artist;
import marceloproject.spotifays.models.Music;

import java.util.List;

public record AlbumDTO(String name, List<Music> musicList, Artist artist) {
}
