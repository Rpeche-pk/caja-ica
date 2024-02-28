package com.lrpa.app.service.usecase;

/**
 * @author ROMULO
 * @package com.lrpa.app.service.usecase
 * @license Lrpa, zephyr cygnus
 * @since 27/2/2024
 */
public interface PokemonService {
    void createPokemon();
    void updatePokemon();
    void deletePokemon();
    void getPokemon();
    void getPokemons();
    void getPokemonsByType();
}
