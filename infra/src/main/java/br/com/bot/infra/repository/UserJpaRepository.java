package br.com.bot.infra.repository;

import br.com.bot.core.model.User;
import br.com.bot.infra.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
