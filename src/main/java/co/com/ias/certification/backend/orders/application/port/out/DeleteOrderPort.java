package co.com.ias.certification.backend.orders.application.port.out;

import co.com.ias.certification.backend.orders.application.domain.OrderId;

public interface DeleteOrderPort {
    void deleteOrder(OrderId id);
}
