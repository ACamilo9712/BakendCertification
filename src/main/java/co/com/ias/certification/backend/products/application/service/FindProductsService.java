package co.com.ias.certification.backend.products.application.service;

import co.com.ias.certification.backend.common.UseCase;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.port.in.FindProductsUseCase;
import co.com.ias.certification.backend.products.application.port.out.FindProductPort;
import co.com.ias.certification.backend.products.application.port.out.FindProductsPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindProductsService implements FindProductsUseCase {
    private final FindProductsPort findProductsPort;

    @Override
    public List<Product> findProduct() {
        return findProductsPort.findProduct();
    }
}
