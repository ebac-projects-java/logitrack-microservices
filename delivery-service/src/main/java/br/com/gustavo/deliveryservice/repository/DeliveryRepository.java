package br.com.gustavo.deliveryservice.repository;

import br.com.gustavo.deliveryservice.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}