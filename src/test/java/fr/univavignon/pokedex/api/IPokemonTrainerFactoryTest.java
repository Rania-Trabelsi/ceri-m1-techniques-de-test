package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.impl.PokemonTrainerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryTest {
    IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    IPokedex pokedex = mock(IPokedex.class);
    PokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();
    PokemonTrainer green =
            pokemonTrainerFactory.createTrainer("Green", Team.MYSTIC,
                    pokedexFactory);

    @Test
    void shouldReturnPokemonTrainer() {
        assertNotNull(green);
    }

    @Test
    void shouldReturnRightName() {
        assertEquals("Green", green.getName());
    }

    @Test
    void shouldReturnRightTeam() {
        assertEquals(Team.MYSTIC, green.getTeam());
    }

    @Test
    void shouldReturnDifferentPokedex() {
        assertNotEquals(pokedex, green.getPokedex());
    }
}