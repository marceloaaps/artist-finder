package marceloproject.spotifays.dtos;

import marceloproject.spotifays.models.Artist;

import java.util.List;

public record MusicDTO(String name, String timeDuration, Double musicRating, List <Artist> featuredArtists) {
}
