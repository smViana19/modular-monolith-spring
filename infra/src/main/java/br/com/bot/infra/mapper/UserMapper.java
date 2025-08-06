package br.com.bot.infra.mapper;

import br.com.bot.core.model.User;
import br.com.bot.infra.entity.UserEntity;

public class UserMapper {

  public static User toDomain(UserEntity entity) {
    return new User(entity.getId(), entity.getName(), entity.getEmail());
  }

  public static UserEntity toEntity(User domain) {
    UserEntity userEntity = new UserEntity();
    userEntity.setId(domain.getId());
    userEntity.setName(domain.getName());
    userEntity.setEmail(domain.getEmail());
    userEntity.setPassword(domain.getPassword());
    return userEntity;
  }
}
