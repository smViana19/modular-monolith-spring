package br.com.bot.core.repository;

import br.com.bot.core.model.User;

import java.util.List;

public interface UserRepository {
  User createUser(User user);
  List<User> getAllUsers() ;
  User getUserById(Long id);
  User getUserByEmail(String email);

}
