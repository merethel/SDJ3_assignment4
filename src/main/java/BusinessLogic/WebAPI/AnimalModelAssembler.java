package BusinessLogic.WebAPI;

import Shared.Animal;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
class AnimalModelAssembler implements RepresentationModelAssembler<Animal, EntityModel<Animal>> {

    @Override
    public EntityModel<Animal> toModel(Animal animal) {

        return EntityModel.of(animal, //
                linkTo(methodOn(AnimalController.class).one(animal.getRegistrationNumber())).withSelfRel(),
                linkTo(methodOn(AnimalController.class).all()).withRel("animals"));
    }
}