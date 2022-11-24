package Shared.Dtos;

import Shared.Model.Animal;
import Shared.Model.Product;
import Shared.Model.Tray;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class AnimalPartCreationDto {

    private int animalIComeFromId;
    private int trayIComeFromId;
    private int weight;
    private String typeOfPart;

    public AnimalPartCreationDto(int animalIComeFromId, int trayIComeFromId, int weight, String typeOfPart) {
        this.animalIComeFromId = animalIComeFromId;
        this.trayIComeFromId = trayIComeFromId;
        this.weight = weight;
        this.typeOfPart = typeOfPart;
    }

    public int getAnimalIComeFromId() {
        return animalIComeFromId;
    }

    public void setAnimalIComeFromId(int animalIComeFromId) {
        this.animalIComeFromId = animalIComeFromId;
    }

    public int getTrayIComeFromId() {
        return trayIComeFromId;
    }

    public void setTrayIComeFromId(int trayIComeFromId) {
        this.trayIComeFromId = trayIComeFromId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getTypeOfPart() {
        return typeOfPart;
    }

    public void setTypeOfPart(String typeOfPart) {
        this.typeOfPart = typeOfPart;
    }

}
