package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
class PokemonTypeController {

    @Autowired
    PokemonTypeService pokemonTypeService;

    public PokemonTypeController(PokemonTypeService service) {
        this.pokemonTypeService = service;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id) {
        return this.pokemonTypeService.getPokemonType(id);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return this.pokemonTypeService.getAllPokemonTypes();
    }


    @GetMapping("/")
    public PokemonType getPokemonTypeFromName(@RequestParam("name") String name){
       return this.pokemonTypeService.getPokemonType(name);
    }
}
