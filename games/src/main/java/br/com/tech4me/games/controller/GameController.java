package br.com.tech4me.games.controller;

import java.util.List;

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

@RestController
@RequestMapping("/game")
public class GameController {
    
    @PostMapping
    public ResponseEntity<Game> CreateGame(@RequestBody Game game)
    {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Game>> GetGames()
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> GetGameById(@PathVariable String id)
    {
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> UpdateGame(@PathVariable String id, Game game )
    {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteGame(@PathVariable String id)
    {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
