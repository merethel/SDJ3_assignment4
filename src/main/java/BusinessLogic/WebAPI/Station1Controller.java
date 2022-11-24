package BusinessLogic.WebAPI;

import BusinessLogic.Logic.LogicInterfaces.IAnimalLogic;
import Shared.Model.Animal;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController

public class Station1Controller {

    private final IAnimalLogic animalLogic;

    private final AnimalModelAssembler assembler;

    public Station1Controller(IAnimalLogic animalLogic, AnimalModelAssembler assembler) {
        this.animalLogic = animalLogic;
        this.assembler = assembler;
    }

    @PostMapping("/animals")
    ResponseEntity<?> newAnimal(@RequestBody Animal newAnimal){
        EntityModel<Animal> entityModel = assembler.toModel(animalLogic.create(newAnimal));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())//
                .body(entityModel);
    }
}
