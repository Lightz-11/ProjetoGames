package br.com.tech4me.games.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.games.model.Game;

public interface GameRepository extends MongoRepository<Game,String>{
    
}
