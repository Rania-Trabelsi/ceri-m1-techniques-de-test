package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.impl.PokedexFactory;
import fr.univavignon.pokedex.api.impl.PokemonFactory;
import fr.univavignon.pokedex.api.impl.PokemonMetadataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class IPokedexFactoryTest {
    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonMetadataProvider pokemonMetadataProvider =
            new PokemonMetadataProvider();
    IPokemonFactory pokemonFactory = new PokemonFactory();
    IPokedex pokedex;

    @BeforeEach
    public void setUp() {
        pokedex = new fr.univavignon.pokedex.api.Pokedex(pokemonMetadataProvider, pokemonFactory);
    }

    @Test
    void shouldReturnSamePokemons() {
        //On vérifie que on arrive bien a crée une classe de type IPokedex
        assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,
                pokemonFactory).getPokemons(), pokedex.getPokemons());
    }
}