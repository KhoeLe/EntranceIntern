package com.example.EntranceIntern.Order;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository <OrderItem, Long>{
    List<OrderItem> findByOrderId(Long orderId);
}
