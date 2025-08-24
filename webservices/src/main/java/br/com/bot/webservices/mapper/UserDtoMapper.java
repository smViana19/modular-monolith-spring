package br.com.bot.webservices.mapper;

import br.com.bot.core.model.User;
import br.com.bot.webservices.dto.UserResponseDTO;

public class UserDtoMapper {

  public static UserResponseDTO toResponse(User user) {
    UserResponseDTO dto = new UserResponseDTO();
    dto.setId(user.getId());
    dto.setName(user.getName());
    dto.setEmail(user.getEmail());
    return dto;
  }
}
