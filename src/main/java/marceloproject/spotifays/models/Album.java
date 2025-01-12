package marceloproject.spotifays.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String albumName;

    @OneToMany (mappedBy = "album", fetch = FetchType.EAGER)
    private List<Music> musicList;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

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

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", Id=" + id +
                ", musicList=" + musicList.stream().map(Music::getName).toList() +
                ", artist=" + artist.getName() +
                '}';
    }
}
