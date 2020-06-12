package co.com.ias.certification.backend.orders.application.port.in;

import co.com.ias.certification.backend.orders.application.domain.OrderId;
import co.com.ias.certification.backend.products.application.domain.Product;

import io.vavr.control.Try;
import lombok.Value;

public interface FindOrderUseCase {

    Try<Product> findOrder(FindOrderQuery query);

    @Value
    class FindOrderQuery {
        OrderId orderId;
    }
}
