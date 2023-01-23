package br.com.tech4me.games.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.games.model.Game;

public interface GameService {

    Game createGame(Game game);

    public List<Game> getGames();

    public Optional<Game> getGameById(String id);

    Optional<Game> editGameById(String id, Game game);

    void deleteGameById(String id);
    
}
