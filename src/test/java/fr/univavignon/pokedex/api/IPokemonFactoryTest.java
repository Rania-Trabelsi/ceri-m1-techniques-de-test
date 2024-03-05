package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;
import org.junit.Test;

public class IPokemonFactoryTest {


    @Test
    public void testCreatePokemon() {

        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);


        Pokemon expectedPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);



        when(pokemonFactory.createPokemon(anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(expectedPokemon);


        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        verify(pokemonFactory).createPokemon(0, 613, 64, 4000, 4);

        // Assert the result
        assertEquals(expectedPokemon, actualPokemon);
    }
}
