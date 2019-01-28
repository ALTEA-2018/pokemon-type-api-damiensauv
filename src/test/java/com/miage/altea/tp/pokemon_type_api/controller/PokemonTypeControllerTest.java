package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokemonTypeControllerTest {

    @Test
    void getPokemonType_shouldCallTheService(){
        var service = mock(PokemonTypeService.class);
        var controller = new PokemonTypeController(service);

        var pikachu = new PokemonType();
        pikachu.setId(25);
        pikachu.setName("pikachu");
        when(service.getPokemonType(25)).thenReturn(pikachu);

        var pokemon = controller.getPokemonTypeFromId(25);
        assertEquals("pikachu", pokemon.getName());

        verify(service).getPokemonType(25);
    }

    @Test
    void getAllPokemonTypes_shouldCallTheService(){
        var service = mock(PokemonTypeService.class);
        var controller = new PokemonTypeController(service);

        controller.getAllPokemonTypes();

        verify(service).getAllPokemonTypes();
    }

}
