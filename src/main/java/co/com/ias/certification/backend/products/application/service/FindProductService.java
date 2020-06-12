package co.com.ias.certification.backend.products.application.service;

import co.com.ias.certification.backend.common.UseCase;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.port.in.FindProductUseCase;
import co.com.ias.certification.backend.products.application.port.out.FindProductPort;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@UseCase
@RequiredArgsConstructor
public class FindProductService implements FindProductUseCase {

    private  final FindProductPort findProductPort;


    @Override
    public Try<Product> findProduct(FindProductQuery query) {
        return Try.of(()->{
            Optional<Product> product = findProductPort.findProduct(query.getProductId());
            return product.orElseThrow(() -> new Exception("Product not found"));
        });
    }
}