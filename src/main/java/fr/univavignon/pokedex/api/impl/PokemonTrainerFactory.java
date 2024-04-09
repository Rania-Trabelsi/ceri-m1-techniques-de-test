package fr.univavignon.pokedex.api.impl;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

/**
 * Pokemon Trainer Factory. Implementation of IPokemonTrainerFactory.
 *
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    /**
     * Creates and return a new trainer.
     *
     *
     * @param name           Name of the created trainer.
     * @param team           Team of the created trainer.
     * @param pokedexFactory Factory for creating associated pokedex instance.
     * @return PokemonTrainer
     */
    @Override
    public PokemonTrainer createTrainer(final String name, final Team team,
                                        final IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team,
                pokedexFactory.createPokedex(new PokemonMetaDataProvider(),
                        new PokemonFactory()));
    }
}