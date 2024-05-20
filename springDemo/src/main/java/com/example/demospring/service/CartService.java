package com.example.demospring.service;

import com.example.demospring.entity.CartItem;
import com.example.demospring.entity.CartItemId;
import com.example.demospring.entity.Product;
import com.example.demospring.entity.ShoppingCart;
import com.example.demospring.entity.dtos.request.CartItemRequest;
import com.example.demospring.repository.CartItemRepository;
import com.example.demospring.repository.ProductRepository;
import com.example.demospring.repository.ShoppingCartRepository;
import com.example.demospring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CartService {
    private CartItemRepository cartItemRepository;
    private ShoppingCartRepository shoppingCartRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    public CartService(CartItemRepository cartItemRepository, ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    public ShoppingCart findShoppingCartByUserId(Integer userId) {
        return shoppingCartRepository.findShoppingCartByUser_Id(userId);
    }

    public ShoppingCart saveCartItem(CartItemRequest cartItem) {
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartByUser_Id(cartItem.getUserId());
        // if there's an existing shopping cart of a user
        if (shoppingCart != null) {
            CartItem itemExisting = null;
            for (CartItem item :
                    shoppingCart.getCartItems()) {
                if (item.getProduct().getId().equals(cartItem.getProductId())) {
                    itemExisting = item;
                    break;
                }
            }
            int quantity;
            Optional<Product> product = productRepository.findById(cartItem.getProductId());
            if (itemExisting != null) {
                quantity = itemExisting.getQuantity() + cartItem.getQuantity();
            } else {
                quantity = cartItem.getQuantity();
                itemExisting = new CartItem();
                itemExisting.setShoppingCart(shoppingCart);
                itemExisting.setTotal(new BigDecimal(0));
                itemExisting.setProduct(product.get());
            }
            if (product.isPresent()) {
                BigDecimal oldCartItemTotal = itemExisting.getTotal();
                itemExisting.setQuantity(quantity);
                itemExisting.setTotal(product.get().getPrice().multiply(new BigDecimal(quantity)));
                shoppingCart.setTotal(shoppingCart.getTotal().subtract(oldCartItemTotal).add(itemExisting.getTotal()));
                shoppingCartRepository.save(shoppingCart);
                cartItemRepository.save(itemExisting);
            }
        } else {
            ShoppingCart newShoppingCart = new ShoppingCart();
            Set<CartItem> cartItems = new LinkedHashSet<>();
            newShoppingCart.setUser(userRepository.findById(cartItem.getUserId()).get());
            CartItem newCartItem = createNewCartItem(cartItem, newShoppingCart);
            newShoppingCart.setTotal(newCartItem.getTotal());
            cartItems.add(newCartItem);
            newShoppingCart.setCartItems(cartItems);
            shoppingCartRepository.save(newShoppingCart);
            cartItemRepository.save(newCartItem);
        }
        return shoppingCart;
    }
    public CartItem removeCartItem(CartItemId cartItemId) {
        Optional<CartItem> removedCartItem = cartItemRepository.findById(cartItemId);
        if (removedCartItem.isPresent()){
            ShoppingCart shoppingCart = removedCartItem.get().getShoppingCart();
            shoppingCart.setTotal(shoppingCart.getTotal().subtract(removedCartItem.get().getTotal()));
            if (shoppingCart.getTotal().equals(new BigDecimal(0))){
                shoppingCartRepository.delete(shoppingCart);
            }else {
                shoppingCartRepository.save(shoppingCart);
            }
            cartItemRepository.delete(removedCartItem.get());
            return removedCartItem.get();
        }
        return null;
    }
    private CartItem createNewCartItem(CartItemRequest cartItem, ShoppingCart shoppingCart){
        Optional<Product> product = productRepository.findById(cartItem.getProductId());
        CartItem newCartItem = new CartItem();
        int quantity = cartItem.getQuantity();
        if (product.isPresent()) {
            newCartItem.setProduct(product.get());
            newCartItem.setQuantity(quantity);
            newCartItem.setTotal(product.get().getPrice().multiply(new BigDecimal(quantity)));
            newCartItem.setShoppingCart(shoppingCart);
        }
        return newCartItem;
    }
}
