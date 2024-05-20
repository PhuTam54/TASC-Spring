package com.example.springDemo.repository;

import com.example.springDemo.entity.OrderDetail;
import com.example.springDemo.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

}
