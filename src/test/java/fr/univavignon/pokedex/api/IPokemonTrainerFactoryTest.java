package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import fr.univavignon.pokedex.api.*;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainer() {

        IPokedexFactory pokedexFactoryMock = mock(IPokedexFactory.class);
        IPokedex pokedexMock = mock(IPokedex.class);
        when(pokedexFactoryMock.createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class))).thenReturn(pokedexMock);

        IPokemonTrainerFactory trainerFactoryMock = mock(IPokemonTrainerFactory.class);


        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.VALOR, pokedexMock);


        when(trainerFactoryMock.createTrainer(eq("Ash"), eq(Team.VALOR), any(IPokedexFactory.class)))
                .thenReturn(trainer);


        PokemonTrainer createdTrainer = trainerFactoryMock.createTrainer("Ash", Team.VALOR, pokedexFactoryMock);

        // Assertions
        assertEquals("Ash", createdTrainer.getName());
        assertEquals(Team.VALOR, createdTrainer.getTeam());
        assertEquals(pokedexMock, createdTrainer.getPokedex());
    }
}
