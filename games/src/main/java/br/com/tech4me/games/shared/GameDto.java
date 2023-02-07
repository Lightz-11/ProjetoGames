package br.com.tech4me.games.shared;

import java.util.List;

import javax.annotation.Nonnegative;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class GameDto {

    private String id;

    @NotEmpty(message = "O campo deve ser informado.")
    @NotBlank(message = "Deve ser informado o nome do jogo.")
    @NotNull(message = "O campo deve conter o nome do jogo.")
    private String name;

    @Positive(message = "Informa um preço válido.")
    @Nonnegative()
    private double price;
    
    @NotEmpty(message = "O campo deve ser informado.")
    @Size(min = 1,max = 10, message = "Informe as categorias onde se encontra o jogo.")
    private List<String> category;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public List<String> getCategory() {
        return category;
    }
    public void setCategory(List<String> category) {
        this.category = category;
    }
}
