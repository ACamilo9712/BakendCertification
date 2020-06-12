package co.com.ias.certification.backend.orders.application.port.in;

import co.com.ias.certification.backend.orders.application.domain.OrderId;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductId;
import co.com.ias.certification.backend.products.application.port.in.DeleteProductUseCase;
import io.vavr.control.Try;
import lombok.Value;

public interface DeleteOrderUseCase {
    Try<Product> deleteOrder(DeleteOrderCommand command);

    @Value
    class DeleteOrderCommand {
        OrderId id;
    }
}
