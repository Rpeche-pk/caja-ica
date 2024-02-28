package com.lrpa.app.persistance.repository;

import com.lrpa.app.persistance.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
    @Query("select p from PokemonEntity p where lower(p.name) like lower(?1)")
    Optional<PokemonEntity> findByNamePokemon(String name);
}