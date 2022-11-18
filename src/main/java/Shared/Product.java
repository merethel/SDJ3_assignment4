package Shared;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column
    @GeneratedValue
    private  int productNumber;
    @Column
    private String date;


    @ManyToMany
    @JoinTable(name="product_animal", joinColumns = @JoinColumn(name="fk_product"), inverseJoinColumns = @JoinColumn(name="fk_animal"))

    private List<Animal> animals;

    public Product() {
    }

    public Product(String date, List<Animal> animals) {
        this.date = date;
        this.animals = animals;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getDate() {
        return date;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

}
