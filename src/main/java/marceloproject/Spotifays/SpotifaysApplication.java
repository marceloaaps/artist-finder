package marceloproject.Spotifays;

import marceloproject.Spotifays.views.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.awt.SystemColor.menu;

@SpringBootApplication
public class SpotifaysApplication implements CommandLineRunner {

	@Autowired
	private Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(SpotifaysApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		menu.showMenu();

	}
}
