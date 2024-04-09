package fr.univavignon.pokedex.api.impl;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.ArrayList;

/**
 * Pokemon metadata provider. Implementation of IPokemonMetadataProver.
 *
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    /**
     * pokemonMetadataArrayList contains the metadata of all Pokemons.
     */

    private ArrayList<PokemonMetadata> pokemonMetadataArrayList;
    /**
     * Bulbizarre's index.
     */
    private static final int BULBIZARRE_INDEX = 0;
    /**
     * Aquali's index.
     */
    private static final int AQUALI_INDEX = 133;
    /**
     * Min Pokemon's index.
     */
    private static final int MAX_INDEX = 150;
    /**
     * Max Pokemon's index.
     */
    private static final int MIN_INDEX = 0;

    /**
     *
     */
    public PokemonMetadataProvider() {
        pokemonMetadataArrayList = new ArrayList<>();
        final int bulbizarreAttack = 126;
        final int bulbizarreDefense = 126;
        final int bulbizarreStamina = 90;
        PokemonMetadata bulbizarre =
                new PokemonMetadata(BULBIZARRE_INDEX, "Bulbizarre",
                        bulbizarreAttack, bulbizarreDefense,
                        bulbizarreStamina);

        final int aqualiAttack = 186;
        final int aqualiDefense = 168;
        final int aqualiStamina = 260;

        PokemonMetadata aquali =
                new PokemonMetadata(AQUALI_INDEX, "Aquali", aqualiAttack,
                        aqualiDefense, aqualiStamina);

        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            if (i == BULBIZARRE_INDEX) {
                pokemonMetadataArrayList.add(bulbizarre);
            } else if (i == AQUALI_INDEX) {
                pokemonMetadataArrayList.add(aquali);
            } else {
                pokemonMetadataArrayList.add(
                        new PokemonMetadata(i, "not captured yet", 0, 0, 0));
            }
        }
    }

    /**
     * Returns the Pokemon at a given index.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return PokemonMetadata
     * @throws PokedexException
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        if (index >= MIN_INDEX && index <= MAX_INDEX) {
            return pokemonMetadataArrayList.get(index);
        }
        throw new PokedexException(
                "Pokemon's indexes are between 0 and 150.");
    }
}
