package com.example.springDemo.repository;

import com.example.springDemo.entity.CartItem;
import com.example.springDemo.entity.CartItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {

}
