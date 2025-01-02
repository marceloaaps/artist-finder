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
}
