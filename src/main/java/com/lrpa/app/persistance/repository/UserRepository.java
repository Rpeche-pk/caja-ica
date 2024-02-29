package com.lrpa.app.persistance.repository;

import com.lrpa.app.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author ROMULO
 * @package com.lrpa.app.persistance.repository
 * @license Lrpa, zephyr cygnus
 * @since 29/2/2024
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
