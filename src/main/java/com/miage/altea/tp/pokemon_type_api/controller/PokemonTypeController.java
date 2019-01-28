package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
class PokemonTypeController {

    @Autowired
    PokemonTypeService pokemonTypeService;

    public PokemonTypeController() {
    }

    public PokemonTypeController(PokemonTypeService service) {
        this.pokemonTypeService = service;
    }

    PokemonType getPokemonTypeFromId(int id) {
        return this.pokemonTypeService.getPokemonType(id);
    }

    public List<PokemonType> getAllPokemonTypes() {
        return this.pokemonTypeService.getAllPokemonTypes();
    }
}
