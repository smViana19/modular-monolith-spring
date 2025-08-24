package br.com.bot.infra.repository;

import br.com.bot.core.model.User;
import br.com.bot.core.repository.UserRepository;
import br.com.bot.infra.entity.UserEntity;
import br.com.bot.infra.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository jpaRepository;

  public UserRepositoryImpl(UserJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }


  @Override
  public User createUser(User user) {
    UserEntity userEntity = UserMapper.toEntity(user);
    UserEntity userSaved = jpaRepository.save(userEntity);
    return UserMapper.toDomain(userSaved);
  }

  @Override
  public List<User> getAllUsers() {
    return jpaRepository.findAll().stream()
        .map(UserMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public User getUserById(Long id) {
    return jpaRepository.findById(id)
        .map(UserMapper::toDomain)
        .orElse(null);
  }

  @Override
  public User getUserByEmail(String email) {
    return jpaRepository.findUserByEmail(email)
        .map(UserMapper::toDomain)
        .orElse(null);
  }
}
