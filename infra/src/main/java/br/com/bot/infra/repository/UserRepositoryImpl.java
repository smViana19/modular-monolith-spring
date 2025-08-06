package br.com.bot.infra.repository;

import br.com.bot.core.model.User;
import br.com.bot.core.repository.UserRepository;
import br.com.bot.infra.entity.UserEntity;
import br.com.bot.infra.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository jpaRepository;

  public UserRepositoryImpl(UserJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public void createUser() {

  }

  @Override
  public List<User> findAllUsers() {
    return jpaRepository.findAll().stream()
        .map(UserMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public User findUserById(Long id) {
    return jpaRepository.findById(id)
        .map(UserMapper::toDomain)
        .orElse(null);
  }
}
