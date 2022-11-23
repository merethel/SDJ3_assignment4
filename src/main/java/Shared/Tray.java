package Shared;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Tray {
    @Id @GeneratedValue
    private int trayNumber;
    private String typeOfPart;
    private int maxWeight;
    @OneToMany
    private List<AnimalPart> parts;

    public Tray(String typeOfPart, int maxWeight, ArrayList<AnimalPart> parts) {
        this.typeOfPart = typeOfPart;
        this.maxWeight = maxWeight;
        this.parts = parts;
    }

    public Tray() {
    }

    public int getTrayNumber() {
        return trayNumber;
    }

    public void setTrayNumber(int trayNumber) {
        this.trayNumber = trayNumber;
    }

    public String getTypeOfPart() {
        return typeOfPart;
    }

    public void setTypeOfPart(String typeOfPart) {
        this.typeOfPart = typeOfPart;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<AnimalPart> getParts() {
        return parts;
    }

    public void setParts(ArrayList<AnimalPart> parts) {
        this.parts = parts;
    }
}
