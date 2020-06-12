package co.com.ias.certification.backend.products.application.service;

import co.com.ias.certification.backend.common.UseCase;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.port.in.DeleteProductUseCase;
import co.com.ias.certification.backend.products.application.port.out.DeleteProductPort;
import co.com.ias.certification.backend.products.application.port.out.FindProductPort;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class DeleteProductService implements DeleteProductUseCase {

    private final DeleteProductPort deleteProductPort;
    private final FindProductPort findProductPort;

    @Override
    public Try<Product> deleteProduct(DeleteProductCommand command) {
        return Try.of(() -> {
            Optional<Product> product = findProductPort.findProduct(command.getId());
            return product.map(productDelete -> {
                deleteProductPort.deleteProduct(command.getId());
                return productDelete;
            }).orElseThrow(() -> new Exception("Product not found"));
         });
    }

}

