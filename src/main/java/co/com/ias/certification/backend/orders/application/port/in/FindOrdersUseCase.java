package co.com.ias.certification.backend.orders.application.port.in;

import co.com.ias.certification.backend.orders.application.domain.Order;


import java.util.List;

public interface FindOrdersUseCase {
    List<Order> findOrders();
}
