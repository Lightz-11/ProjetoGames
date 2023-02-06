package br.com.tech4me.pedidos.shared;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PedidoDto {
    private String id;

    @NotEmpty(message = "O campo deve ser informado")
    @NotBlank(message = "Deve ser informado o Cliente.")
    @NotNull(message = "O campo dos clientes não poder estar vazio.")
    private String cliente;

    @NotEmpty(message = "O campo deve ser informado")
    @NotBlank(message = "Deve ser informado o id do jogo que deseja comprar.")
    @NotNull(message = "O id do jogo não pode estar vazio.")
    private String gameId;
    
    @PositiveOrZero(message = "Informa um preço válido.")
    private double price;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getGameId() {
        return gameId;
    }
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


}
