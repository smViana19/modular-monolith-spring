package br.com.bot.core.service;

import br.com.bot.core.exception.NotFoundException;
import br.com.bot.core.model.User;
import br.com.bot.core.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }


  public User createUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.createUser(user);
  }

  public List<User> findAllUsers() throws NotFoundException {
    return userRepository.getAllUsers();
  }

  public User findUserById(Long id) throws NotFoundException {
    User user = userRepository.getUserById(id);
    if (user == null) {
      throw new NotFoundException("User not found");
    }
    return user;
  }

  public User getUserByEmail(String email) throws NotFoundException {
    User user = userRepository.getUserByEmail(email);
    if (user == null) {
      throw new NotFoundException("User not found");
    }
    return user;
  }

}
