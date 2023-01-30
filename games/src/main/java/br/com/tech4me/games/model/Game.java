package br.com.tech4me.games.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Document("/game")
public class Game {

    @Id
    private String id;
    @NotBlank(message = "")
    @NotNull(message = "")
    private String name;
    @PositiveOrZero(message = "")
    private double price;
    @NotBlank(message = "")
    @NotNull(message = "")
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
