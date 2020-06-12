package co.com.ias.certification.backend.products.application.port.out;

import co.com.ias.certification.backend.products.application.domain.Product;
import io.vavr.control.Try;

public interface IndexProductPort {
    Try<Product> indexProduct(Product product);
}
