package com.borohm.vocab.vocab_trainer_back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borohm.vocab.vocab_trainer_back.model.User;
import com.borohm.vocab.vocab_trainer_back.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
  
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @PostMapping
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
