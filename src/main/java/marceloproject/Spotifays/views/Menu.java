package marceloproject.Spotifays.views;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Tuple;
import marceloproject.Spotifays.dtos.AlbumDTO;
import marceloproject.Spotifays.dtos.ArtistDTO;
import marceloproject.Spotifays.dtos.MusicDTO;
import marceloproject.Spotifays.models.Artist;
import marceloproject.Spotifays.models.Music;
import marceloproject.Spotifays.models.enums.ArtistType;
import marceloproject.Spotifays.services.AlbumService;
import marceloproject.Spotifays.services.ArtistService;
import marceloproject.Spotifays.services.MenuService;
import marceloproject.Spotifays.services.MusicService;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Menu {

    @Autowired
    MenuService menuService;


    public Menu() {
    }

    public void showMenu() {

        System.out.println("Bem vindo ao Spotifays! ");
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        menuService.showOptions();

        do {

            if (sc.hasNextInt()) {
                int switchNumber = sc.nextInt();
                switch (switchNumber) {
                    case 1 -> {
                        menuService.insertArtist(); menuService.showOptions();
                    }
                    case 2 -> {
                        menuService.insertMusic();
                        menuService.showOptions();
                    }
                    case 3 -> {
                        menuService.insertAlbum();
                        menuService.showOptions();
                    }
                    case 4 -> {
                        menuService.listArtists();
                        menuService.showOptions();
                    }
                    default -> {
                        System.out.println("Informação inválida, favor digitar novamente");

                    }
                }
            } else {
                System.out.println("Entrada inválida, favor digitar novamente");
                sc.nextLine();
            }
        } while (running);
        sc.close();
    }

}
