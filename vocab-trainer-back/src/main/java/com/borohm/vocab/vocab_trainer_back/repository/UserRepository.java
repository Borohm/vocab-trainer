package com.borohm.vocab.vocab_trainer_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.borohm.vocab.vocab_trainer_back.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
