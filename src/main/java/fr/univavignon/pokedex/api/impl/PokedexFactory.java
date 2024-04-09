package fr.univavignon.pokedex.api.impl;

import fr.univavignon.pokedex.api.*;

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
        return new fr.univavignon.pokedex.api.Pokedex(metadataProvider, pokemonFactory);
    }

}