package br.com.bot.webservices.mapper;

import br.com.bot.core.model.User;
import br.com.bot.webservices.dto.UserResponse;

public class UserDtoMapper {

  public static UserResponse toResponse(User user) {
    UserResponse dto = new UserResponse();
    dto.setId(user.getId());
    dto.setName(user.getName());
    dto.setEmail(user.getEmail());
    return dto;
  }
}
