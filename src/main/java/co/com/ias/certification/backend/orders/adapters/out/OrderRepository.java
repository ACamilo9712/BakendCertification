package co.com.ias.certification.backend.orders.adapters.out;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderJpaEntity, Long> {
}
