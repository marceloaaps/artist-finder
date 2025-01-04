package marceloproject.Spotifays.dtos;

import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.models.Music;

import java.util.List;

public record AlbumDTO(String name, List<Music> musicList, Artist artist) {
}
