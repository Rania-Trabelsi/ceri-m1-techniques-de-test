package fr.univavignon.pokedex.api.impl;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.impl.Pokedex;

/**
 * Pokedex Factoy. Is the implementation of IPokdexFacory.
 */
public class PokedexFactory implements IPokedexFactory {
    /**
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory   Pokemon factory the created pokedex will use.
     * @return Pokedex
     */
    @Override
    public IPokedex createPokedex(
            final IPokemonMetadataProvider metadataProvider,
            final IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }

}