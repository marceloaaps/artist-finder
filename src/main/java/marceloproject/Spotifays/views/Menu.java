package marceloproject.Spotifays.views;


import marceloproject.Spotifays.dtos.ArtistDTO;
import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.models.enums.ArtistType;
import marceloproject.Spotifays.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.lang.model.type.ArrayType;
import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private ArtistService artistService;

    public Menu() {
    }

    public void showMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao Spotifays! ");

        System.out.println("Qual operação deseja realizar?");
        System.out.println("1 - Adicionar artista");

        var switchNumber = sc.nextInt();

        switch(switchNumber){

            case 1:
                System.out.println("Nome do Artista");
                var artistName = sc.nextLine();
                System.out.println("Idade do Artista");
                var artistAge = sc.nextLine();
                System.out.println("Onde o artista nasceu");
                var artistWasBorn = sc.nextLine();
                System.out.println("Biografia do artista");
                var artistBiography = sc.nextLine();
                System.out.print("Qual o tipo dele? \n 1 - Solo \n 2 -  Dupla \n 3 - Trio \n 4 -  Banda");
                int typeCode = sc.nextInt();

                ArtistType artistType = ArtistType.fromCode(typeCode);

                ArtistDTO artistDTO = new ArtistDTO(artistName, artistWasBorn, artistAge, artistBiography, artistType);

                artistService.insertArtist(artistDTO);

        }
    }
}
