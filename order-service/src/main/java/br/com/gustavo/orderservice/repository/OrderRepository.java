package br.com.gustavo.orderservice.repository;

import br.com.gustavo.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}