import java.util.Iterator;

import components.map.Map;
import components.map.Map1L;

/**
 * {@code FPLDataTracker} represented as a {@code Map} of player names to their
 * individual stat maps.
 *
 * @convention Each key in {@code playerStats} is a unique {@code String}
 *             representing a player name. Each value is a
 *             {@code Map<String, String>} representing a mapping of statistic
 *             names (e.g., "goals", "assists") to their corresponding values
 *             (as Strings).
 *
 * @correspondence this = entries(playerStats), where each (playerName, stats)
 *                 pair in {@code playerStats} corresponds to a player tracked
 *                 by the component, and {@code stats} represents that player's
 *                 current statistics as a {@code Map}.
 */
public class FPLDataTracker1 extends FPLDataTrackerSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Internal representation of player data.
     */
    private Map<String, Map<String, String>> playerStats;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.playerStats = new Map1L<>();
    }

    /*
     * Constructor ------------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public FPLDataTracker1() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @SuppressWarnings("unchecked")
    @Override
    public final FPLDataTracker newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(FPLDataTrackerKernel source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof FPLDataTracker1 : "Violation of: source is of dynamic type FPLDataTracker1";

        FPLDataTracker1 localSource = (FPLDataTracker1) source;
        this.playerStats = localSource.playerStats;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public void addPlayer(String name, Map<String, String> stats) {
        assert name != null : "Violation of: name is not null";
        assert stats != null : "Violation of: stats is not null";
        assert !this.containsPlayer(
                name) : "Violation of: name is not already in this";

        this.playerStats.add(name, stats);
    }

    @Override
    public void removePlayer(String name) {
        assert name != null : "Violation of: name is not null";
        assert this.containsPlayer(name) : "Violation of: name is in this";

        this.playerStats.remove(name);
    }

    @Override
    public void updatePlayerStats(String name, Map<String, String> stats) {
        assert name != null : "Violation of: name is not null";
        assert stats != null : "Violation of: stats is not null";
        assert this.containsPlayer(name) : "Violation of: name is in this";

        this.playerStats.replaceValue(name, stats);
    }

    @Override
    public boolean containsPlayer(String name) {
        assert name != null : "Violation of: name is not null";

        return this.playerStats.hasKey(name);
    }

    @Override
    public int getPlayerCount() {
        return this.playerStats.size();
    }

    @Override
    public Iterator<String> iterator() {
        return this.playerStats.keyIterator();
    }
}
