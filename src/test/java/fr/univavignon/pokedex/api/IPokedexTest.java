package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class IPokedexTest {
    private IPokedex pokedex;

    @Before

    public void setUp() {
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testAddPokemon() {
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);

        int index = pokedex.addPokemon(bulbasaur);

        assertEquals(0, index);
        verify(pokedex).addPokemon(bulbasaur);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);

        Pokemon result = pokedex.getPokemon(0);

        assertEquals(bulbasaur, result);
        verify(pokedex).getPokemon(0);
    }

    @Test
    public void testGetSize() {
        when(pokedex.size()).thenReturn(1);

        int size = pokedex.size();

        assertEquals(1, size);
        verify(pokedex).size();
    }

    @Test
    public void testGetPokemons() {
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon ivysaur = new Pokemon(1, "Ivysaur", 186, 168, 260, 2729, 202, 5000, 4, 100);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(bulbasaur, ivysaur));

        List<Pokemon> pokemons = pokedex.getPokemons();

        assertEquals(Arrays.asList(bulbasaur, ivysaur), pokemons);
        verify(pokedex).getPokemons();
    }
}