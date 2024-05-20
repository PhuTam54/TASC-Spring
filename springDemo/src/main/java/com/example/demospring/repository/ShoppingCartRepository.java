package com.example.demospring.repository;

import com.example.demospring.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    ShoppingCart findShoppingCartByUser_Id(Integer id);
}
