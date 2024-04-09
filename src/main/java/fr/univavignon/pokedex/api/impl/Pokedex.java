package fr.univavignon.pokedex.api.impl;



import fr.univavignon.pokedex.api.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pokedex class. Implementation of the IPokedex interface.
 *
 *
 */
public class Pokedex implements IPokedex {
    /**
     * pokemonArrayList stores all Pokemon in the Pokedex.
     */
    private final ArrayList<Pokemon> pokemonsArrayList;

    /**
     * pokemonMetaDataPrive provides metadata information
     * for all pokemons.
     */
    private final IPokemonMetadataProvider pokemonMetadataProvider;
    /**
     * pokemonFactory creates Pokemon to add to the Pokedex.
     */
    private final IPokemonFactory pokemonFactory;

    /**
     * Constructs a new Pokedex.
     *
     * @param pokemonMetadataProvider1
     * @param pokemonFactory1
     */
    public Pokedex(final IPokemonMetadataProvider pokemonMetadataProvider1,
                   final IPokemonFactory pokemonFactory1) {
        this.pokemonFactory = pokemonFactory1;
        this.pokemonMetadataProvider = pokemonMetadataProvider1;
        this.pokemonsArrayList = new ArrayList<>();
    }

    /**
     * Returns the number of Pokemons in the Pokedex.
     *
     * @return int size of the Pokedex.
     */
    @Override
    public int size() {
        return pokemonsArrayList.size();
    }

    /**
     * @param pokemon Pokemon to add to this pokedex.
     * @return index of the newly added pokemon or -1 if fail
     */
    @Override
    public int addPokemon(final Pokemon pokemon) {
        if (pokemon != null) {
            pokemonsArrayList.add(pokemon);
            return pokemonsArrayList.size() - 1;
        }
        return -1;
    }

    /**
     * @param id Unique pokedex relative identifier.
     * @return pokemon at position id
     * @throws PokedexException
     */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        try {
            return pokemonsArrayList.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Pokemon not found.");
        }
    }

    /**
     * @return all pokemons arrayList
     */
    @Override
    public List<Pokemon> getPokemons() {
        return pokemonsArrayList;
    }

    /**
     * @param order Comparator instance used for sorting the created view.
     * @return
     */

    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        ArrayList<Pokemon> pokemons = new ArrayList<>(pokemonsArrayList);
        pokemons.sort(order);
        return pokemons;
    }

    /**
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Pokemon
     */
    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp,
                                 final int dust,
                                 final int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * @param index Index of the pokemon to retrieve metadata for.
     * @return PokemonMetadata
     * @throws PokedexException
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
