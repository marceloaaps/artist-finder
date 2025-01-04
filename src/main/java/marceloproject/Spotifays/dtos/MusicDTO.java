package marceloproject.Spotifays.dtos;

import marceloproject.Spotifays.models.Artist;

import java.util.List;

public record MusicDTO(String name, String timeDuration, Double musicRating, List <Artist> featuredArtists) {
}
