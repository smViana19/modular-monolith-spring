package br.com.bot.core.service;

import br.com.bot.core.exception.NotFoundException;
import br.com.bot.core.model.User;
import br.com.bot.core.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAllUsers() throws NotFoundException {
    return userRepository.findAllUsers();
  }

  public User findUserById(Long id) throws NotFoundException {
    User user = userRepository.findUserById(id);
    if(user == null) {
      throw new NotFoundException("User not found");
    }
    return user;
  }

}
