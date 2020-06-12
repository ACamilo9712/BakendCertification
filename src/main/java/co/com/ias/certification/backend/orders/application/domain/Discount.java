package co.com.ias.certification.backend.orders.application.domain;

import co.com.ias.certification.backend.products.application.domain.BasePrice;
import co.com.ias.certification.backend.serialization.NumberSerializable;
import com.google.common.base.Preconditions;
import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class Discount implements NumberSerializable {

    BigDecimal value;

    public  static Discount fromNumber(Number number){
        return new Discount(BigDecimal.valueOf(number.doubleValue()));
    }

    private Discount(BigDecimal value) {
        Preconditions.checkNotNull(value, "Base price can not be null");
        Preconditions.checkArgument(value.compareTo(BigDecimal.ZERO) >= 0, "Base price can not be negative");
        this.value = value;
    }

    @Override
    public Number valueOf() {
        return null;
    }
}
