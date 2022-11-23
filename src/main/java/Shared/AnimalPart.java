package Shared;

import javax.persistence.*;
import java.util.List;

@Entity

public class AnimalPart {

    @Id @GeneratedValue
    private int id;

    @ManyToOne
    private Animal animalIComeFrom;
    @OneToOne
    private Tray trayIComeFrom;
    private int weight;

    private String typeOfPart;

    @OneToMany
    private List<Product> productList;


    public AnimalPart()
    {
    }

    public AnimalPart(Animal animalIComeFrom, int weight, String typeOfPart)
    {
        this.animalIComeFrom = animalIComeFrom;
        this.weight = weight;
        this.typeOfPart = typeOfPart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimalIComeFrom() {
        return animalIComeFrom;
    }

    public void setAnimalIComeFrom(Animal animalIComeFrom) {
        this.animalIComeFrom = animalIComeFrom;
    }

    public Tray getTrayIComeFrom() {
        return trayIComeFrom;
    }

    public void setTrayIComeFrom(Tray trayIComeFrom) {
        this.trayIComeFrom = trayIComeFrom;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getTypeOfPart() {
        return typeOfPart;
    }

    public void setTypeOfPart(String typeOfPart) {
        this.typeOfPart = typeOfPart;
    }
}
