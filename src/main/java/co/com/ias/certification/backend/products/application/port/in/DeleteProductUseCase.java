package co.com.ias.certification.backend.products.application.port.in;

import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductId;
import io.vavr.control.Try;
import lombok.Value;

public interface DeleteProductUseCase {
    Try<Product> deleteProduct(DeleteProductCommand command);

    @Value
    class DeleteProductCommand {
        ProductId id;
    }
}
