package com.example.springDemo.service;

import com.example.springDemo.entity.User;
import com.example.springDemo.obj.ResultDTO;
import com.example.springDemo.obj.UserDTO;
import com.example.springDemo.projection.UserProjection;
import com.example.springDemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Collection<User> findByName(String name) {
        return userRepository.findByName(name);
    }



    public Collection<User> findByNameNative(String name) {
        return userRepository.findByNameNative(name);
    }
//
//    public List<UserDTO> getUserAndCart() {
//        return userRepository.getUserAndCart();
//    }
//
//    public List<UserProjection> getUserAndCartProjection() {
//        return userRepository.getUserAndCartProjection();
//    }
//
//    public List<ResultDTO> findResultDTOByCustomer(int id) {
//        return userRepository.findResultDTOByCustomer(id);
//    }
}
