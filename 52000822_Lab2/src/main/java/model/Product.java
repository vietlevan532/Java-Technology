package model;

public class Product {
    public String name, color;
    public float price;
    public int id;

    public Product() {
    }

    ;

    public Product(String name, String color, float price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public Product(String name, String color, float price, int id) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }

}
