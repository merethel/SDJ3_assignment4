package Shared.Assemblers;

import Shared.Model.Animal;
import Shared.Model.AnimalPart;
import Shared.Model.Product;
import animals.AnimalMessage;
import animals.AnimalPartMessage;
import animals.ProductMessage;

import java.util.ArrayList;
import java.util.List;

public class ProductAssembler {

    public static Product fromMessageToProduct(ProductMessage productToAssemble){
        List<AnimalPart> animalPartList = new ArrayList<>();

        for (AnimalPartMessage animalPartMessage:productToAssemble.getAnimalIdsList()) {
            AnimalPart animalPart = AnimalPartAssembler.fromMessageToAnimalPart(animalPartMessage);
            animalPartList.add(animalPart);
        }


        Product product = new Product(
                productToAssemble.getDate(),
                animalPartList);
        product.setProductNumber(productToAssemble.getId());
        return product;
    }

    public static ProductMessage fromProductToMessage(Product product){
            List<AnimalPartMessage> animalList = new ArrayList<>();

            for (AnimalPart part: product.getAnimalParts()) {
                AnimalPartMessage animalPartMessage = AnimalPartAssembler.fromAnimalPartToMessage(part);
                animalList.add(animalPartMessage);
            }

            ProductMessage message = ProductMessage.newBuilder()
                .setId(product.getProductNumber())
                .setDate(product.getDate()).build();
        return message;
    }

}
