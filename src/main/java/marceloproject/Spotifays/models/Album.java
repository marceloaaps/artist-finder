package marceloproject.Spotifays.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String albumName;

    @OneToMany (mappedBy = "album")
    private List<Music> musicList;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void addMusicListToAlbum(List<Music> musicList){
        this.musicList = musicList;
    }

}
