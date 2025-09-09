package models;

import enums.FoodCategory;

public class FoodItem {
    private int id;
    private String name;
    private double price;
    private FoodCategory category;

    public FoodItem(){
        this.id = 0;
        this.name = "Unname Item";
        this.price = 0.0;
        this.category = FoodCategory.OTHER;
    }

    public FoodItem(int id, String name, double price, FoodCategory category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "FoodItem {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
