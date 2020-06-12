package co.com.ias.certification.backend.orders.application.port.in;

import co.com.ias.certification.backend.orders.application.domain.OrderNotCreated;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductNotCreated;
import io.vavr.control.Try;
import lombok.Value;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;

public interface CreateOrderUseCase {

    Try<Product> createOrder(CreateOrderCommand command);

    Try<Boolean> userHasPermission(KeycloakAuthenticationToken authenticationToken);

    @Value(staticConstructor = "of")
    class CreateOrderCommand {
        OrderNotCreated orderNotCreated;
    }

}
