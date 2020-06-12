package co.com.ias.certification.backend.orders.application.domain;

import co.com.ias.certification.backend.serialization.NumberSerializable;
import com.google.common.base.Preconditions;

import java.math.BigDecimal;

public class Total implements NumberSerializable {

    BigDecimal value;

    public  static Total fromNumber(Number number){
        return new Total(BigDecimal.valueOf(number.doubleValue()));
    }

    private Total(BigDecimal value) {
        Preconditions.checkNotNull(value, "Total can not be null");
        Preconditions.checkArgument(value.compareTo(BigDecimal.ZERO) >= 0, "Base price can not be negative");
        this.value = value;
    }

    @Override
    public Number valueOf() {
        return null;
    }
}
