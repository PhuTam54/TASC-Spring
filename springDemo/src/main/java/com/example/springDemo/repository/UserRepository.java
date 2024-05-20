package com.example.springDemo.repository;

import com.example.springDemo.obj.ResultDTO;
import com.example.springDemo.obj.UserDTO;
import com.example.springDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springDemo.projection.UserProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select c from User c where c.userName = :name")
    Collection<User> findByName(String name);

    @Query(value = "select * from User u where u.userName = 1?", nativeQuery = true)
    Collection<User> findByNameNative(String name);

//    @Query("select new ResultDTO (c.userName, BigDecimal(sc.total)) from User c INNER JOIN ShoppingCart sc ON c.id = sc.user.id")
//    List<UserDTO> getUserAndCart();
//
//    @Query("select c.userName as name , p.total as phoneNumber from User c INNER JOIN ShoppingCart p ON c.id = p.user.id")
//    List<UserProjection> getUserAndCartProjection();
//
//    @Query(value = "SELECT new ResultDTO(c.id, o.id, p.id, c.userName, c.email, o.createdAt, p.product.name, BigDecimal(p.product.price)) "
//            + " from User c, Order o ,OrderDetail p "
//            + " where c.id=o.user.id "
//            + " and o.id=p.order.id "
//            + " and c.id=?1 ")
//    List<ResultDTO> findResultDTOByCustomer(int id);
}
