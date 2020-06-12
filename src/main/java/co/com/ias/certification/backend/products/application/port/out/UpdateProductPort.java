package co.com.ias.certification.backend.products.application.port.out;

import co.com.ias.certification.backend.products.application.domain.ProductId;
import co.com.ias.certification.backend.products.application.domain.ProductNotCreated;
import co.com.ias.certification.backend.products.application.domain.Product;
import io.vavr.control.Try;

public interface UpdateProductPort {
    Try<Product> updateProduct(ProductId id, ProductNotCreated product);
}
