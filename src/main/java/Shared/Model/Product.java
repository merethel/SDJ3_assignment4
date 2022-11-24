package Shared.Model;

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


    @OneToMany()
    private List<AnimalPart> animalParts;

    public Product() {
    }

    public Product(String date, List<AnimalPart> animalParts) {
        this.date = date;
        this.animalParts = animalParts;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getDate() {
        return date;
    }

    public List<AnimalPart> getAnimalParts() {
        return animalParts;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAnimals(List<AnimalPart> animalParts) {
        this.animalParts = animalParts;
    }

}
