package br.com.tech4me.games.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.games.model.Game;
import br.com.tech4me.games.repository.GameRepository;
import br.com.tech4me.games.shared.GameDto;

@Service
public class GameServiceImp implements GameService{

    @Autowired
    private GameRepository repo;
  
    @Override
    public GameDto createGame(GameDto dto) {

      Game game = new ModelMapper().map(dto, Game.class);
      repo.save(game);
      return new ModelMapper().map(game, GameDto.class);
    }
  
    @Override
    public List<GameDto> getGames() {
      List<Game> game = repo.findAll();

      return game.stream().map(g -> new ModelMapper().map(g, GameDto.class)).collect(Collectors.toList());
    }
  
    @Override
    public Optional<GameDto> getGameById(String id) {
      Optional<Game> game = repo.findById(id);

      if(game.isPresent())
      {
        return Optional.of(new ModelMapper().map(game.get(), GameDto.class));
      }else
      {
        return Optional.empty();

      }
    }
  
    @Override
    public Optional<GameDto> editGameById(String id, GameDto dto) {
  
      Optional<Game> gameAntigo = repo.findById(id);

      if (gameAntigo.isPresent()) {
        dto.setId(id);
        repo.save(new ModelMapper().map(dto, Game.class));
        return Optional.of(dto);

      } else {
        return Optional.empty();
      }
    }
  
    @Override
    public void deleteGameById(String id) {
      repo.deleteById(id);
    }
    
}
