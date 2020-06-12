package co.com.ias.certification.backend.products.adapters.out;


import co.com.ias.certification.backend.common.PersistenceAdapter;
import co.com.ias.certification.backend.products.application.domain.Product;
import co.com.ias.certification.backend.products.application.domain.ProductId;
import co.com.ias.certification.backend.products.application.domain.ProductNotCreated;
import co.com.ias.certification.backend.products.application.port.in.FindProductsUseCase;
import co.com.ias.certification.backend.products.application.port.out.*;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
public class ProductPersistenceAdapter implements CreateProductPort, UpdateProductPort, DeleteProductPort, FindProductPort, FindProductsPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public Try<Product> createProduct(ProductNotCreated product) {
        return Try.of(() -> {
            ProductJpaEntity productJpaEntity = productMapper.mapToJpaEntity(product);
            ProductJpaEntity createdProduct = productRepository.save(productJpaEntity);
            return productMapper.mapToDomainEntity(createdProduct);
        });
    }


    @Override
    public Try<Product> updateProduct(ProductId productId, ProductNotCreated product) {
        return Try.of(() -> {
            Long id = productId.getValue();
            Optional<ProductJpaEntity> currentProductOptional = productRepository.findById(id);
            ProductJpaEntity updateEntity = productMapper.mapToJpaEntity(product);
            return currentProductOptional
                    .map(productJpaEntity -> {
                        productJpaEntity.setName(updateEntity.getName());
                        productJpaEntity.setDescription(updateEntity.getDescription());
                        productJpaEntity.setBasePrice(updateEntity.getBasePrice());
                        productJpaEntity.setTaxRate(updateEntity.getTaxRate());
                        productJpaEntity.setStatus(updateEntity.getStatus());
                        productJpaEntity.setInventoryQuantity(updateEntity.getInventoryQuantity());
                        ProductJpaEntity updatedProduct = productRepository.save(productJpaEntity);
                        return productMapper.mapToDomainEntity(updatedProduct);
                    })
                    .orElseThrow(() -> new NullPointerException("Product not found"));
        });
    }


    @Override
    public void deleteProduct(ProductId productId) {
        productRepository.deleteById(productId.getValue());
    }

    @Override
    public Optional<Product> findProduct(ProductId id) {
        return productRepository.findById(id.getValue()).map(productJpaEntity -> {
            return productMapper.mapToDomainEntity(productJpaEntity);
        });

    }

    @Override
    public List<Product> findProduct() {
        List<ProductJpaEntity> products = (List<ProductJpaEntity>) productRepository.findAll();
        return products.stream().map(product -> productMapper.mapToDomainEntity(product)).collect(Collectors.toList());
    }
}