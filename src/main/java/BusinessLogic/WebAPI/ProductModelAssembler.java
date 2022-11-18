package BusinessLogic.WebAPI;

import Shared.Animal;
import Shared.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product product) {

        return EntityModel.of(product, //
                linkTo(methodOn(AnimalController.class).one((long) product.getProductNumber())).withSelfRel(),
                linkTo(methodOn(AnimalController.class).all()).withRel("animals"));
    }
}
