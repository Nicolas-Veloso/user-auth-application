package br.com.nicolas.projeto_user_authentication.repository;

import br.com.nicolas.projeto_user_authentication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
