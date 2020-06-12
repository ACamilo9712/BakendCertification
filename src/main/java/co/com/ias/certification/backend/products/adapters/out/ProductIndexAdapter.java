package co.com.ias.certification.backend.products.adapters.out;

import co.com.ias.certification.backend.common.PersistenceAdapter;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.port.out.IndexProductPort;
import com.google.gson.Gson;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductIndexAdapter implements IndexProductPort {

    private final ProductMapper productMapper;
    private final Gson gson;

    @Override
    public Try<Product> indexProduct(Product product) {
        return Try.of(() -> {
            String id = product.getId().getValue().toString();
            ProductIndexEntity productIndexEntity = productMapper.mapToIndexEntity(product);
            String jsonDocument = gson.toJson(productIndexEntity);

            return product;
        });
    }
}
