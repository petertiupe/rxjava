package de.tiupe.rxjava.entity;

public class Article {
    String name;
    Double price;

    public Article(String aName, Double aPrice){
        this.name = aName;
        this.price = aPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
