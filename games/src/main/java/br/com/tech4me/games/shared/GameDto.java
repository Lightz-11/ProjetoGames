package br.com.tech4me.games.shared;

import java.util.List;

public class GameDto {
    private String id;
    private String name;
    private double price;
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
