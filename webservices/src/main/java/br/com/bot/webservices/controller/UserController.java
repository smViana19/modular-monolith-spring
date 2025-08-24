package br.com.bot.webservices.controller;


import br.com.bot.core.model.User;
import br.com.bot.core.service.UserService;
import br.com.bot.webservices.dto.UserRequestDTO;
import br.com.bot.webservices.dto.UserResponseDTO;
import br.com.bot.webservices.mapper.UserDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {


  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<User> createUser(@RequestBody UserRequestDTO dto) {
    User user = new User(dto.getName(), dto.getEmail(), dto.getPassword());
    User createdUser = userService.createUser(user);
    return ResponseEntity.ok(createdUser);
  }

  @GetMapping("/")
  public List<UserResponseDTO> findAllUsers() {
    return userService.findAllUsers().stream()
        .map(UserDtoMapper::toResponse)
        .collect(Collectors.toList());
  }
}
