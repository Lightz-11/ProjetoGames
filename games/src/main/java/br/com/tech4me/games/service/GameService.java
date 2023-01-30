package br.com.tech4me.games.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.games.shared.GameDto;

public interface GameService {

    GameDto createGame(GameDto dto);

    public List<GameDto> getGames();

    public Optional<GameDto> getGameById(String id);

    Optional<GameDto> editGameById(String id, GameDto dto);

    void deleteGameById(String id);
    
}
