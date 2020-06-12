package co.com.ias.certification.backend.products.application.port.out;

import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductId;
import co.com.ias.certification.backend.products.application.domain.ProductNotCreated;
import io.vavr.control.Try;

import java.util.Optional;

public interface FindProductPort {
    Optional<Product> findProduct(ProductId id);
}
