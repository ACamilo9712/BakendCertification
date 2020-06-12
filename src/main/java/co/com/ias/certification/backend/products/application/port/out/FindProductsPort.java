package co.com.ias.certification.backend.products.application.port.out;

import co.com.ias.certification.backend.products.application.domain.Product;


import java.util.List;

public interface FindProductsPort {
    List<Product> findProduct();
}
