package co.com.ias.certification.backend.orders.application.port.out;

import co.com.ias.certification.backend.orders.application.domain.Order;
import co.com.ias.certification.backend.orders.application.domain.OrderId;

import java.util.Optional;

public interface FindOrderPort {
    Optional<Order> findOrder(OrderId id);
}
