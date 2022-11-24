package BusinessLogic.WebAPI;

import BusinessLogic.Logic.LogicInterfaces.IAnimalLogic;
import BusinessLogic.Logic.LogicInterfaces.IAnimalPartLogic;
import Shared.Dtos.AnimalPartCreationDto;
import Shared.Model.Animal;
import Shared.Model.AnimalPart;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Station2Controller {

    private final IAnimalLogic animalLogic;

    private final IAnimalPartLogic animalPartLogic;
    private final AnimalModelAssembler assembler;
    private final AnimalPartModelAssembler animalPartModelAssembler;

    public Station2Controller(IAnimalLogic animalLogic, IAnimalPartLogic animalPartLogic, AnimalModelAssembler assembler, AnimalPartModelAssembler animalPartModelAssembler) {
        this.animalLogic = animalLogic;
        this.animalPartLogic = animalPartLogic;
        this.assembler = assembler;
        this.animalPartModelAssembler = animalPartModelAssembler;
    }

    @GetMapping("/animals/{registrationNumber}")
    EntityModel<Animal> one(@PathVariable int registrationNumber) {

        Animal animal = null;
        try {
            animal = animalLogic.getById((registrationNumber)); //
        } catch (Exception e)
        {
            throw new AnimalNotFoundException(registrationNumber);
        }

        return assembler.toModel(animal);
    }

    @PostMapping("/animalparts")
    ResponseEntity<?> newAnimalPart(@RequestBody AnimalPartCreationDto newAnimalPart) {
        EntityModel<AnimalPart> entityModel = animalPartModelAssembler.toModel(animalPartLogic.create(newAnimalPart));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())//
                .body(entityModel);
    }
}
