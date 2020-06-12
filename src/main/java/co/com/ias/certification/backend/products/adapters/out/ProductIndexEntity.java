package co.com.ias.certification.backend.products.adapters.out;


import lombok.Value;

@Value(staticConstructor = "of")
public class ProductIndexEntity {
    String name;
    String description;
}
