package co.com.ias.certification.backend.products.application.port.in;

import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductId;
import co.com.ias.certification.backend.products.application.domain.ProductNotCreated;
import io.vavr.control.Try;
import lombok.Value;

public interface UpdateProductUseCase {

    Try<Product> updateProduct(UpdateProductCommand command);

    @Value
    class UpdateProductCommand {
        ProductId id;
        ProductNotCreated product;
    }
}

