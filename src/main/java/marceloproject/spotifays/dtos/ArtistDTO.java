package marceloproject.spotifays.dtos;

import marceloproject.spotifays.models.enums.ArtistType;

public record ArtistDTO(String name,
                        String countryWasBorn,
                        String age,
                        String biography,
                        ArtistType artistType) {}
