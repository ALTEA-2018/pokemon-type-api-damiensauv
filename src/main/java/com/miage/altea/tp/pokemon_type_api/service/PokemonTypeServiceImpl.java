package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    @Autowired
    public PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    public TranslationRepository translationRepository;

    public PokemonTypeServiceImpl() { // TODO

    }

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository, TranslationRepository translationRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
        this.translationRepository = translationRepository;
    }

    @Override
    public PokemonType getPokemonType(int id) {

        Locale locale = LocaleContextHolder.getLocale();

        PokemonType pokemonTypeById = this.pokemonTypeRepository.findPokemonTypeById(id);
        String pokemonName = translationRepository.getPokemonName(id, locale);
        pokemonTypeById.setName(pokemonName);
        return pokemonTypeById;
    }

    @Override
    public List<PokemonType> getAllPokemonTypes() {

        Locale locale = LocaleContextHolder.getLocale();

        List<PokemonType> allPokemonType = this.pokemonTypeRepository.findAllPokemonType();
        for (PokemonType pokemonType : allPokemonType) {

            String pokemonName = translationRepository.getPokemonName(pokemonType.getId(), locale);
            pokemonType.setName(pokemonName);
        }
        return allPokemonType;
    }

    @Override
    public PokemonType getPokemonType(String name) {
        return this.pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> getallPokememonList(List<String> types) {
        return this.pokemonTypeRepository.getallPokememonList(types);
    }

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }
}
