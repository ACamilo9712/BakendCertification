package co.com.ias.certification.backend.orders.application.port.out;

import co.com.ias.certification.backend.orders.application.domain.Order;

import java.util.List;

public interface FindOrdersPort {
    List<Order> findOrders();
}
