package co.com.ias.certification.backend.configuration;

import co.com.ias.certification.backend.products.application.domain.*;
import co.com.ias.certification.backend.serialization.NumberValueAdapter;
import co.com.ias.certification.backend.serialization.StringValueAdapter;
import co.com.ias.certification.backend.serialization.TryAdapter;
import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import io.vavr.control.Try;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GsonConfiguration {
    @Bean
    public Gson gson() {


        return new GsonBuilder()

                .registerTypeAdapter(BasePrice.class, new NumberValueAdapter<>(BasePrice::fromNumber))
                .registerTypeAdapter(ProductId.class, new NumberValueAdapter<>(ProductId::fromNumber))
                .registerTypeAdapter(TaxRate.class, new NumberValueAdapter<>(TaxRate::fromNumber))
                .registerTypeAdapter(Quantity.class, new NumberValueAdapter<>(Quantity::fromNumber))
                .registerTypeAdapter(ProductName.class, new StringValueAdapter<>(ProductName::of))
                .registerTypeAdapter(ProductDescription.class, new StringValueAdapter<>(ProductDescription::of))
                .registerTypeAdapter(Try.class, new TryAdapter<>())
                .create();
}
}
