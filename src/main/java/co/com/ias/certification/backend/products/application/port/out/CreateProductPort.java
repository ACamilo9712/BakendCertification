package co.com.ias.certification.backend.products.application.port.out;

import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductNotCreated;
import io.vavr.control.Try;

public interface CreateProductPort {

    Try<Product> createProduct(ProductNotCreated product);
}
