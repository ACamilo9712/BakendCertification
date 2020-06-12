package co.com.ias.certification.backend.orders.application.port.out;

import co.com.ias.certification.backend.orders.application.domain.Order;
import co.com.ias.certification.backend.orders.application.domain.OrderId;
import co.com.ias.certification.backend.orders.application.domain.OrderNotCreated;
import io.vavr.control.Try;

public interface UpdateOrderPort {
    Try<Order> updateProduct(OrderId id, OrderNotCreated order);
}
