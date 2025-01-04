package marceloproject.Spotifays.views;


import jakarta.persistence.Tuple;
import marceloproject.Spotifays.dtos.ArtistDTO;
import marceloproject.Spotifays.dtos.MusicDTO;
import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.models.enums.ArtistType;
import marceloproject.Spotifays.services.ArtistService;
import marceloproject.Spotifays.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Menu {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private MusicService musicService;

    public Menu() {
    }

    public void showMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao Spotifays! ");

        System.out.println("Qual operação deseja realizar?");
        System.out.println("1 - Adicionar artista");
        System.out.println("2 - Adicionar musica");

        int switchNumber = sc.nextInt();

        switch (switchNumber) {
            case 1:
                sc.nextLine(); // Consumir quebra de linha pendente

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
                sc.nextLine(); // Consumir quebra de linha pendente

                ArtistType artistType = ArtistType.fromCode(typeCode);
                ArtistDTO artistDTO = new ArtistDTO(artistName, artistWasBorn, artistAge, artistBiography, artistType);
                artistService.insertArtist(artistDTO);
                break;

            case 2:
                List<Artist> artistList = new ArrayList<>();

                System.out.println("Nome da Música:");
                var musicName = sc.nextLine();
                System.out.println("Duração da música (minutos e segundos):");
                var musicDuration = sc.nextLine();
                System.out.println("Avaliação da música:");
                var musicRating = sc.nextDouble();
                sc.nextLine();
                System.out.println("Quantidade de features que essa música tem:");
                var featureQuantity = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha pendente

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
                    sc.nextLine(); // Consumir quebra de linha pendente

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
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}
