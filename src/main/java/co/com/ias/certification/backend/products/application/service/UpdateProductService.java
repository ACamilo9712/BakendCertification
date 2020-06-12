package co.com.ias.certification.backend.products.application.service;

import co.com.ias.certification.backend.common.UseCase;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.port.in.UpdateProductUseCase;
import co.com.ias.certification.backend.products.application.port.out.UpdateProductPort;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {
    private final UpdateProductPort updateProductPort;

    @Override
    public Try<Product> updateProduct(UpdateProductCommand command) {
        return updateProductPort.updateProduct(command.getId(), command.getProduct());
    }
}
