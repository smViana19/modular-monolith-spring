package br.com.bot.core.repository;

import br.com.bot.core.model.User;

import java.util.List;

public interface UserRepository {
  void createUser();
  List<User> findAllUsers() ;
  User findUserById(Long id);

}
