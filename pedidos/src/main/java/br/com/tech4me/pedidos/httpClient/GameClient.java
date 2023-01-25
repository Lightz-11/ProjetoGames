package main.java.br.com.tech4me.pedidos.httpClient;

import main.java.br.com.tech4me.pedidos.model.Game;

@FeignClient("games")
public interface GameClient {
    @RequestMapping(method = RequestMethod.GET,value = "/pedidos/{id}")
    Game obterGame(@PathVariable String id);
}
