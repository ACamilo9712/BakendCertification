package co.com.ias.certification.backend.orders.application.domain;
import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Order {
    OrderId orderId;
    Discount discount;
    OrderStatus orderStatus;
    Total total;

    public Order (OrderId id, Discount discount, OrderStatus orderStatus, Total total){
        this.orderId = Preconditions.checkNotNull(id);
        this.discount = Preconditions.checkNotNull(discount);
        this.orderStatus = Preconditions.checkNotNull(orderStatus);
        this.total = Preconditions.checkNotNull(total);
    }
}
