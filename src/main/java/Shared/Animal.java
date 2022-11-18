package Shared;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "animal")
public class Animal {
    @Id @GeneratedValue @Column
    private  int registrationNumber;
    @Column
    private int weight;
    @Column
    private String date;
    @Column
    private String origin;

    @ManyToMany(mappedBy = "animals")

    private List<Product> products;

    public Animal(int weight, String date, String origin) {
        this.weight = weight;
        this.date = date;
        this.origin = origin;
    }

    public Animal() {
    }


    public int getWeight() {
        return weight;
    }

    public String getDate() {
        return date;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}