package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;


    private IPokedexFactory getPokedexFactory() {

        return mock(IPokedexFactory.class);
    }

    @Before
    public void setUp() {

        pokedexFactory = getPokedexFactory();
    }

    @Test
    public void testCreatePokedex() {

        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);


        IPokedex pokedex = mock(IPokedex.class);


        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);


        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(createdPokedex);
    }
}
