package game.door.boot.api.rest;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import game.door.boot.api.bean.Game;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class Application {
	
	private ArrayList<Game> gameList = new ArrayList<Game>() {
	    {
	        add(new Game(1, "test 1", "test game 1"));
	        add(new Game(2, "test 2", "test game 2"));
	        add(new Game(3, "test 3", "test game 3"));
	        add(new Game(4, "test 4", "test game 4"));
	        add(new Game(5, "test 5", "test game 5"));
	    }
	};
	
	public static void main(String[] args) {
		System.out.println("Let's start with Spring Boot");
		SpringApplication.run(Application.class, args);      
	}	

    @RequestMapping(value = "/games", method = RequestMethod.GET)       
    public ArrayList<Game> getAllGame() {
    	return gameList;
    }
    
    @RequestMapping(value = "/games/{id}", method = RequestMethod.GET)       
    public ArrayList<Game> getGameById(@PathVariable("id") int id) {
    	ArrayList<Game> list = new ArrayList<Game>();
    	gameList.stream().filter((p) -> (p.getId() == id)).parallel().forEachOrdered(list::add);
    	return list;
    }
	
}
