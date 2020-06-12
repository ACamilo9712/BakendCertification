package co.com.ias.certification.backend.products.adapters.in.web;

import co.com.ias.certification.backend.common.WebAdapter;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductId;
import co.com.ias.certification.backend.products.application.port.in.*;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import java.util.List;

@RestController
@WebAdapter
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUserCase;
    private  final DeleteProductUseCase deleteProductUseCase;
    private final FindProductUseCase findProductUseCase;
    private final FindProductsUseCase findProductsUseCase;


    @PostMapping
    public Try<Product> createProduct(@RequestBody CreateProductUseCase.CreateProductCommand command, Authentication authentication) {
        KeycloakAuthenticationToken authenticationToken = (KeycloakAuthenticationToken) authentication;
        return createProductUseCase.userHasPermission(authenticationToken)
                .flatMap(permission -> createProductUseCase.createProduct(command));
    }

    @PutMapping
    Try<Product> updateProduct(@RequestBody UpdateProductUseCase.UpdateProductCommand command) {
        return updateProductUserCase.updateProduct(command);
    }

    @GetMapping
    private Try<Product> findProduct(@RequestBody FindProductUseCase.FindProductQuery query){
        return  findProductUseCase.findProduct(query);
    }

    @DeleteMapping
    private Try<Product> deleteProduct (@RequestBody DeleteProductUseCase.DeleteProductCommand command){
        System.out.println(command);
        return  deleteProductUseCase.deleteProduct(command);
    }

    @GetMapping("/all")
    private List<Product> findProducts(){
        return findProductsUseCase.findProduct();
    }



}
