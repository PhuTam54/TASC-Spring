package com.example.demospring.controller;

import com.example.demospring.entity.CartItem;
import com.example.demospring.entity.CartItemId;
import com.example.demospring.entity.ShoppingCart;
import com.example.demospring.entity.dtos.request.CartItemRequest;
import com.example.demospring.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("api/v1/carts")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUserCart(@RequestParam(name = "userId") int userId) {
        ShoppingCart shoppingCart = cartService.findShoppingCartByUserId(userId);
        if (shoppingCart != null){
            return ResponseEntity.ok(shoppingCart);
        }
        return ResponseEntity.notFound().build();
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addItemToCart(@RequestBody CartItemRequest cartItemRequest){
        return ResponseEntity.ok(cartService.saveCartItem(cartItemRequest));
    }
    @RequestMapping(method = RequestMethod.POST, path = "delete")
    public ResponseEntity<?> removeCartItem(@RequestBody CartItemId cartItemId){
        CartItem returnResult = cartService.removeCartItem(cartItemId);
        if (returnResult != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
