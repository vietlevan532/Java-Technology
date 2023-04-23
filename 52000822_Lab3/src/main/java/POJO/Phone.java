package POJO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Phone {
    public String name, color, country;
    public int id, price, quantity;

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 120)
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "color", nullable = false, length = 20)
    public String getColor() {
        return color;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 50)
    public String getCountry() {
        return country;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", country='" + country + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id == phone.id && price == phone.price && quantity == phone.quantity && name.equals(phone.name) && color.equals(phone.color) && country.equals(phone.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, country, id, price, quantity);
    }

    public void showInfo() {
        System.out.println(this);
    }
}
