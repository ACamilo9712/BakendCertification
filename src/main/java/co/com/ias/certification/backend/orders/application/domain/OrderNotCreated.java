package co.com.ias.certification.backend.orders.application.domain;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class OrderNotCreated {
    Discount discount;
    OrderStatus orderStatus;
    Total total;

    public OrderNotCreated ( Discount discount, OrderStatus orderStatus, Total total){
        this.discount = Preconditions.checkNotNull(discount);
        this.orderStatus = Preconditions.checkNotNull(orderStatus);
        this.total = Preconditions.checkNotNull(total);
    }
}
