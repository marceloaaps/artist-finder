package marceloproject.Spotifays.dtos;

import marceloproject.Spotifays.models.enums.ArtistType;

public record ArtistDTO(String name,
                        String countryWasBorn,
                        String age,
                        String biography,
                        ArtistType artistType) {}
