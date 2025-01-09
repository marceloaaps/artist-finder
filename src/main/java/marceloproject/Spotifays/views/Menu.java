package marceloproject.Spotifays.views;

import marceloproject.Spotifays.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Menu {

    @Autowired
    MenuService menuService;

    public void showMenu() {

        System.out.println("Bem vindo ao Spotifays! ");
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        menuService.showOptions();

        while (running) {

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
                    case 5 -> {
                        System.out.println("Saindo do sistema...");
                        running = false;
                    }
                    default -> System.out.println("Informação inválida, favor digitar novamente");
                }
            } else {
                System.out.println("Entrada inválida, favor digitar novamente");
                sc.nextLine();
            }
        }
        sc.close();
    }

}
