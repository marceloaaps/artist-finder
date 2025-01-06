package marceloproject.Spotifays.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Tuple;
import marceloproject.Spotifays.dtos.AlbumDTO;
import marceloproject.Spotifays.dtos.ArtistDTO;
import marceloproject.Spotifays.dtos.MusicDTO;
import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.models.Music;
import marceloproject.Spotifays.models.enums.ArtistType;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class MenuService {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private MusicService musicService;

    @Autowired
    private AlbumService albumService;

    public void showOptions() {
        System.out.println("Qual operação deseja realizar?");
        System.out.println("1 - Adicionar artista");
        System.out.println("2 - Adicionar musica");
        System.out.println("3 - Adicionar álbum");
        System.out.println("4 - Listar artistas");
        System.out.println("5 - Sair");
    }

    public void insertArtist() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nome do Artista:");
            var artistName = sc.nextLine();
            System.out.println("Idade do Artista:");
            var artistAge = sc.nextLine();
            System.out.println("Onde o artista nasceu:");
            var artistWasBorn = sc.nextLine();
            System.out.println("Biografia do artista:");
            var artistBiography = sc.nextLine();
            System.out.print("Qual o tipo dele? \n 1 - Solo \n 2 - Dupla \n 3 - Trio \n 4 - Banda\n");
            int typeCode = sc.nextInt();
            sc.nextLine();

            ArtistType artistType = ArtistType.fromCode(typeCode);
            ArtistDTO artistDTO = new ArtistDTO(artistName, artistWasBorn, artistAge, artistBiography, artistType);
            artistService.insertArtist(artistDTO);

        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertMusic() {
        try (Scanner sc = new Scanner(System.in)) {
            sc.nextLine();

            System.out.println("Nome da Música:");
            var musicName = sc.nextLine();
            System.out.println("Duração da música (minutos e segundos):");
            var musicDuration = sc.nextLine();
            System.out.println("Avaliação da música:");
            var musicRating = sc.nextDouble();
            sc.nextLine();
            System.out.println("Quantidade de features que essa música tem:");
            var featureQuantity = sc.nextInt();
            sc.nextLine();

            List<Artist> artistList = new ArrayList<>();

            for (int i = 0; i < featureQuantity; i++) {
                System.out.println("Digite o nome do artista que você deseja adicionar na música:");
                var name = sc.nextLine();

                List<Tuple> foundArtist = artistService.findArtistByName(name);
                foundArtist.forEach(f -> {
                    var idFound = f.get(0, Long.class);
                    var nameFound = f.get(1, String.class);
                    System.out.println("ID: " + idFound + " - Name: " + nameFound);
                });

                System.out.println("Se o artista foi encontrado, digite SIM, senão, digite NAO:");
                var verifyFound = sc.nextLine();
                if ("NAO".equalsIgnoreCase(verifyFound)) {
                    continue;
                }

                System.out.println("Qual o ID desse artista?");
                var verifyCode = sc.nextLong();
                sc.nextLine();

                Artist artist = artistService.findById(verifyCode);
                if (artist != null) {
                    System.out.println("Artista encontrado: " + artist.getName());
                    artistList.add(artist);
                } else {
                    System.out.println("Artista não encontrado com o ID fornecido.");
                }
            }
            MusicDTO musicDTO = new MusicDTO(musicName, musicDuration, musicRating, artistList);
            musicService.insertMusic(musicDTO);
        } catch (InvalidPropertyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertAlbum() {
        try (Scanner sc = new Scanner(System.in)) {
            sc.nextLine();

            List<Music> musicList = new ArrayList<>();
            System.out.println("Qual o nome do álbum?");
            var albumName = sc.nextLine();

            List<Artist> allArtistsList = artistService.findAll();
            allArtistsList.forEach(a -> System.out.println("ID: " + a.getId() + " - Nome: " + a.getName()));

            System.out.println("Esse álbum pertence a qual artista presente no sistema? Por ID");
            var artistId = sc.nextInt() - 1;
            Artist artistFound = allArtistsList.get(artistId);
            System.out.println(artistFound.getName() + artistFound.getAge());

            System.out.println("Quantas músicas tem nesse álbum?");
            var musicQuantity = sc.nextInt();

            for (int i = 1; i <= musicQuantity; i++) {
                System.out.println("Qual o nome da música que você deseja adicionar a esse álbum?");
                var musicFound = sc.nextLine();

                List<Music> musicFoundList = musicService.findMusicByName(musicFound);
                musicFoundList.forEach(m -> System.out.println("ID: " + m.getId() + " - Nome: " + m.getName()));

                System.out.println("Qual das acima?");
                var musicCertain = sc.nextInt() - 1;

                Music musicCertainFound = musicFoundList.get(musicCertain);
                System.out.println(musicCertainFound.toString());
                musicList.add(musicCertainFound);
            }

            AlbumDTO albumDTO = new AlbumDTO(albumName, musicList, artistFound);
            albumService.insertAlbum(albumDTO);
        } catch (InvalidPropertyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listArtists() {
        try (Scanner sc = new Scanner(System.in)) {
            {
                System.out.println("Qual o nome do artista que você deseja saber mais?");
                var artistName = sc.nextLine();

                List<Tuple> foundArtists = artistService.findArtistByName(artistName);
                Tuple firstArtistTuple = foundArtists.get(0);
                String artistNameTuple = firstArtistTuple.get(1, String.class);
                Long artistId = firstArtistTuple.get(0, Long.class);

                System.out.println("Nome do artista: " + artistNameTuple);
                System.out.println(artistService.findArtistByName(artistName));

                System.out.println("Oque mais você deseja saber desse artista?");
                System.out.println("1 - Álbuns");
                int option = sc.nextInt();

                switch (option) {
                    case 1 -> System.out.println(albumService.findAlbumByArtist(artistId));
                }
            }
        } catch (InvalidPropertyException e) {
            System.out.println(e.getMessage());
        }
    }
}
