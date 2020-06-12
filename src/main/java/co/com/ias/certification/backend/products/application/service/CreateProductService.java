package co.com.ias.certification.backend.products.application.service;


import co.com.ias.certification.backend.common.UseCase;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductNotCreated;
import co.com.ias.certification.backend.products.application.port.in.CreateProductUseCase;
import co.com.ias.certification.backend.products.application.port.out.CreateProductPort;
import co.com.ias.certification.backend.products.application.port.out.IndexProductPort;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

@UseCase
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final CreateProductPort createProductPort;
    private final IndexProductPort indexProductPort;

    @Override
    public Try<Product> createProduct(CreateProductCommand command) {
        ProductNotCreated product = command.getProduct();
        return createProductPort.createProduct(product)
                .flatMap(indexProductPort::indexProduct);
    }

    @Override
    public Try<Boolean> userHasPermission(KeycloakAuthenticationToken authenticationToken) {
        return Try.success(true);
    }
}
