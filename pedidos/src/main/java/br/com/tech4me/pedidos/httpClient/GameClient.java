package br.com.tech4me.pedidos.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.pedidos.model.Game;

@FeignClient("games")
public interface GameClient {
    @RequestMapping(method = RequestMethod.GET,value = "/pedidos/{id}")
    Game obterGame(@PathVariable String id);
}
