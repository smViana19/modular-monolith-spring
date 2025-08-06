package br.com.bot.webservices.controller;


import br.com.bot.core.service.UserService;
import br.com.bot.webservices.dto.UserResponse;
import br.com.bot.webservices.mapper.UserDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<UserResponse> findAllUsers() {
    return userService.findAllUsers().stream()
        .map(UserDtoMapper::toResponse)
        .collect(Collectors.toList());
  }
}
