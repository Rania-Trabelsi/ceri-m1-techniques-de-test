package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.impl.PokemonFactory;
import fr.univavignon.pokedex.api.impl.PokemonMetadataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokedexTest {
    IPokemonMetadataProvider pokemonMetadataProvider =
            new PokemonMetadataProvider();
    IPokemonFactory pokemonFactory = new PokemonFactory();
    IPokedex pokedex;
    Pokemon bulbizarre =
            new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aquali =
            new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 5, 1000);
    List<Pokemon> pokemonList = new ArrayList<>();

    @BeforeEach
    void setUp() throws IndexOutOfBoundsException {
        pokedex = new fr.univavignon.pokedex.api.Pokedex(pokemonMetadataProvider, pokemonFactory);
        pokedex.addPokemon(bulbizarre);
        pokemonList.add(bulbizarre);
    }

    @Test
    void shouldThrowPokedexException() {
        Exception thrown = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(-1);
        });

        assertEquals(thrown.getMessage(), "Pokemon not found.");
    }

    @Test
    void shouldRetunMinusOne(){
        int index = pokedex.addPokemon(null);
        assertEquals(index, -1);
    }

    @Test
    void shouldGetRightMetadata() throws PokedexException {
        assertEquals(pokedex.getPokemonMetadata(0), pokemonMetadataProvider.getPokemonMetadata(0));
    }
    @Test
    void shouldCreateTheRightPokemon() throws PokedexException {
        Pokemon pokemon = pokedex.createPokemon(42, 1, 2, 3, 4);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(pokedex.getPokemon(index), pokemon);
        assertEquals(pokemon.getCp(), 1);
        assertEquals(pokemon.getHp(), 2);
        assertEquals(pokemon.getDust(), 3);
        assertEquals(pokemon.getCandy(), 4);
    }

    @Test
    void shouldReturnSameSize() {
        assertEquals(pokedex.size(), pokemonList.size());
    }

    @Test
    void shouldReturnTheSameIndex() throws PokedexException {
        int currentIndex = pokemonList.size();
        assertEquals(pokedex.addPokemon(aquali), currentIndex);
        pokemonList.add(aquali);
    }

    @Test
    void shouldReturnTheRightPokemon() throws PokedexException {
        assertEquals(pokedex.getPokemon(0), pokemonList.get(0));
        assertEquals(pokedex.getPokemon(0).getIndex(), bulbizarre.getIndex());
        assertEquals(pokedex.getPokemon(0).getName(), bulbizarre.getName());
        assertEquals(pokedex.getPokemon(0).getAttack(), bulbizarre.getAttack());
        assertEquals(pokedex.getPokemon(0).getDefense(),
                bulbizarre.getDefense());
        assertEquals(pokedex.getPokemon(0).getStamina(),
                bulbizarre.getStamina());
        assertEquals(pokedex.getPokemon(0).getCp(), bulbizarre.getCp());
        assertEquals(pokedex.getPokemon(0).getCandy(), bulbizarre.getCandy());
        assertEquals(pokedex.getPokemon(0).getDust(), bulbizarre.getDust());
        assertEquals(pokedex.getPokemon(0).getHp(), bulbizarre.getHp());
        assertEquals(pokedex.getPokemon(0).getIv(), bulbizarre.getIv());

        assertNotEquals(pokedex.getPokemon(0).getName(), aquali.getName());
    }

    @Test
    void shouldReturnSamePokemonList() throws PokedexException {
        assertEquals(pokedex.getPokemons(), pokemonList);
    }

    @Test
    void shouldHaveSameNumberOfPokemons() {
        assertEquals(pokedex.getPokemons().size(), pokemonList.size());
    }

    @Test
    void shouldReturnListOrderedByIndexAndByNames() {
        pokemonList.add(aquali);
        pokedex.addPokemon(aquali);
        assertEquals(pokemonList,
                pokedex.getPokemons(PokemonComparators.INDEX));
        ArrayList<Pokemon> pokemonsOrderedByName = new ArrayList<>();
        pokemonsOrderedByName.add(aquali);
        pokemonsOrderedByName.add(bulbizarre);
        assertEquals(pokemonsOrderedByName,
                pokedex.getPokemons(PokemonComparators.NAME));
    }

}