package co.com.ias.certification.backend.orders.application.port.in;

import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductId;
import co.com.ias.certification.backend.products.application.domain.ProductNotCreated;
import io.vavr.control.Try;
import lombok.Value;

public interface UpdateOrdersCaseUse {

    Try<Product> updateOrder(UpdateOrderCommand command);

    @Value
    class UpdateOrderCommand {
        ProductId id;
        ProductNotCreated product;
    }

}
