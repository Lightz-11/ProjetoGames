package br.com.tech4me.games.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.games.model.Game;
import br.com.tech4me.games.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;
    
    @PostMapping
    public ResponseEntity<Game> CreateGame(@RequestBody Game game)
    {
        return new ResponseEntity<>(service.createGame(game), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Game>> GetGames()
    {
        return new ResponseEntity<>(service.getGames(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> GetGameById(@PathVariable String id)
    {
        Optional<Game> gameAntigo = service.getGameById(id);

        if (gameAntigo.isPresent()) {
            return new ResponseEntity<>(gameAntigo.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> UpdateGame(@PathVariable String id, Game game )
    {
        Optional<Game> antigoGame = service.editGameById(id, game);
        //Optional<Game> antigoGame = Optional.of(game);

        if (antigoGame.isPresent()) {
            return new ResponseEntity<>(antigoGame.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Game> DeleteGame(@PathVariable String id)
    {
        Optional<Game> antigoGame = service.getGameById(id);
        service.deleteGameById(id);

        if (antigoGame.isPresent()) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
