package BusinessLogic.WebAPI;

import BusinessLogic.Logic.LogicInterfaces.IAnimalLogic;
import BusinessLogic.Logic.LogicInterfaces.IAnimalPartLogic;
import BusinessLogic.Logic.LogicInterfaces.IProductLogic;
import Shared.Dtos.AnimalPartCreationDto;
import Shared.Model.Animal;
import Shared.Model.AnimalPart;
import Shared.Model.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Station3Controller {

    private final IProductLogic productLogic;
    private final ProductModelAssembler productModelAssembler;

    public Station3Controller(IProductLogic productLogic, ProductModelAssembler productModelAssembler) {
        this.productLogic = productLogic;
        this.productModelAssembler = productModelAssembler;
    }

    @PostMapping("/products")
    ResponseEntity<?> newAnimalPart(@RequestBody Product newProduct) {
        EntityModel<Product> entityModel = productModelAssembler.toModel(productLogic.create(newProduct));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())//
                .body(entityModel);
    }
}
