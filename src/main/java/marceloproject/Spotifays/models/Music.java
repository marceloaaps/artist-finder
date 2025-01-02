package marceloproject.Spotifays.models;


import jakarta.annotation.Nullable;
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
    private String musicName;
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

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
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
}
