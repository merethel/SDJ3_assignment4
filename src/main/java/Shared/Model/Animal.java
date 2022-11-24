package Shared.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Animal_sequence")
    @SequenceGenerator(sequenceName = "Animal_sequence", allocationSize = 1, name = "Animal_sequence")
    @Column
    private  int registrationNumber;
    @Column
    private int weight;
    @Column
    private String date;
    @Column
    private String origin;

    @OneToMany
    private List<AnimalPart> animalParts;

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

    public List<AnimalPart> getAnimalParts() {
        return animalParts;
    }

    public void setAnimalParts(List<AnimalPart> animalParts) {
        this.animalParts = animalParts;
    }
}