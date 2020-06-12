package co.com.ias.certification.backend.orders.adapters.out;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDERS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    BigDecimal discount;

    @Column
    String orderStatus;

    @Column
    BigDecimal total;





}
