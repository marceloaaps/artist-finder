package marceloproject.Spotifays.models;

import jakarta.persistence.*;
import marceloproject.Spotifays.models.enums.ArtistType;

import java.util.List;

@Entity
@Table (name = "tb_artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private ArtistType artistType;
    private String age;
    private String countryWasBorn;
    private Integer numberOfHits;
    private String biography;

    @ManyToMany(mappedBy = "featuredArtists")
    private List<Music> featuredIn;

    @OneToMany(mappedBy = "artist")
    private List<Album> albumList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistType getArtistType() {
        return artistType;
    }

    public void setArtistType(ArtistType artistType) {
        this.artistType = artistType;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountryWasBorn() {
        return countryWasBorn;
    }

    public void setCountryWasBorn(String countryWasBorn) {
        this.countryWasBorn = countryWasBorn;
    }

    public Integer getNumberOfHits() {
        return numberOfHits;
    }

    public void setNumberOfHits(Integer numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
