package br.com.tech4me.games.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.games.model.Game;
import br.com.tech4me.games.repository.GameRepository;

@Service
public class GameServiceImp implements GameService{

    @Autowired
    private GameRepository repo;
  
    @Override
    public Game createGame(Game game) {
      return repo.save(game);
    }
  
    @Override
    public List<Game> getGames() {
      return repo.findAll();
    }
  
    @Override
    public Optional<Game> getGameById(String id) {
      return repo.findById(id);
    }
  
    @Override
    public Optional<Game> editGameById(String id, Game game) {
  
      Optional<Game> gameAntigo = repo.findById(id);
  
      if (gameAntigo.isPresent()) {
        game.setId(id);
        return Optional.of(repo.save(game));
      } else {
        return Optional.empty();
      }
    }
  
    @Override
    public void deleteGameById(String id) {
      repo.deleteById(id);
    }
    
}
