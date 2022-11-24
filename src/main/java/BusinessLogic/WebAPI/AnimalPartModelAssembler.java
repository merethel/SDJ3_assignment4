package BusinessLogic.WebAPI;

import Shared.Model.AnimalPart;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class AnimalPartModelAssembler implements RepresentationModelAssembler<AnimalPart, EntityModel<AnimalPart>> {

    @Override
    public EntityModel<AnimalPart> toModel(AnimalPart animalPart) {

        return EntityModel.of(animalPart, //
                linkTo(methodOn(AnimalController.class).one(animalPart.getId())).withSelfRel(),
                linkTo(methodOn(AnimalController.class).all()).withRel("animalparts"));
    }
}
