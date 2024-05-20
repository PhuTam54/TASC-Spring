package com.example.demospring.repository;

import com.example.demospring.entity.OrderDetail;
import com.example.demospring.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

}
