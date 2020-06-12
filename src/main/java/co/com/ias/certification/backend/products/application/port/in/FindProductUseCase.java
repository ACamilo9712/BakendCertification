package co.com.ias.certification.backend.products.application.port.in;

import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductId;
import io.vavr.control.Try;
import lombok.Value;


public interface FindProductUseCase {
    Try<Product> findProduct(FindProductQuery query);

    @Value
    class FindProductQuery {
        ProductId productId;
    }
}


