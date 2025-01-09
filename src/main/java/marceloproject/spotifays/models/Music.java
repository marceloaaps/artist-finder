package marceloproject.spotifays.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "music_artist",
            joinColumns = @JoinColumn(name = "music_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )

    private List<Artist> featuredArtists;
    private String timeDurantion;
    private Double musicRating;

    public Music() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeDurantion() {
        return timeDurantion;
    }

    public void setTimeDurantion(String timeDurantion) {
        this.timeDurantion = timeDurantion;
    }

    public Double getMusicRating() {
        return musicRating;
    }

    public void setMusicRating(Double musicRating) {
        this.musicRating = musicRating;
    }

    public void addFeaturedArtist(List<Artist> artistList){
        this.featuredArtists = artistList;
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }


}
