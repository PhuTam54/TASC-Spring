package com.example.demospring.repository;

import com.example.demospring.entity.CartItem;
import com.example.demospring.entity.CartItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {

}
