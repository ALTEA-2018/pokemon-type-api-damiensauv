package com.miage.altea.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);

        return this.pokemons.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);
        return this.pokemons.stream().filter(x -> name.equals(x.getName())).findFirst().orElse(null);
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return this.pokemons;
    }

    @Override
    public List<PokemonType> getallPokememonList(List<String> types) {
        return this.pokemons
                .stream()
                .filter(pokemon -> types.size() > 1 ? pokemon.getTypes().containsAll(types) : pokemon.getTypes().stream().anyMatch(types::contains))
                .collect(Collectors.toList());
    }

}
