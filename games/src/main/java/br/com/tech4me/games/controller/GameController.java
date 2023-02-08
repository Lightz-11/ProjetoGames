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

import br.com.tech4me.games.service.GameService;
import br.com.tech4me.games.shared.GameDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;
    
    @PostMapping
    public ResponseEntity<GameDto> CreateGame(@Valid@RequestBody GameDto game)
    {
        return new ResponseEntity<>(service.createGame(game), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GameDto>> GetGames()
    {
        return new ResponseEntity<>(service.getGames(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> GetGameById(@PathVariable String id)
    {
        Optional<GameDto> gameAntigo = service.getGameById(id);

        if (gameAntigo.isPresent()) {
            return new ResponseEntity<>(gameAntigo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDto> editGameById(@Valid @PathVariable String id, @RequestBody GameDto game) {

        Optional<GameDto> antigoGame = service.editGameById(id, game);

        return new ResponseEntity<>(antigoGame.get(), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GameDto> DeleteGame(@PathVariable String id)
    {
        Optional<GameDto> antigoGame = service.getGameById(id);
        service.deleteGameById(id);

        if (antigoGame.isPresent()) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
