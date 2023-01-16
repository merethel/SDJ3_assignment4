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

//@RestController
public class Station2Controller {

    private final IAnimalPartLogic animalPartLogic;
    private final AnimalPartModelAssembler animalPartModelAssembler;

    public Station2Controller(IAnimalPartLogic animalPartLogic, AnimalPartModelAssembler animalPartModelAssembler) {
        this.animalPartLogic = animalPartLogic;
        this.animalPartModelAssembler = animalPartModelAssembler;
    }


    @PostMapping("/animalparts")
    ResponseEntity<?> newAnimalPart(@RequestBody AnimalPartCreationDto newAnimalPart) {
        EntityModel<AnimalPart> entityModel = animalPartModelAssembler.toModel(animalPartLogic.create(newAnimalPart));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())//
                .body(entityModel);
    }

}
