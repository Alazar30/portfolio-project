package components.fpldatatracker;

import components.standard.Standard;

/**
 * Interface for the FPL Data Tracker component with kernel methods.
 */
public interface FPLDataTrackerKernel extends Standard<FPLDataTracker> {

    /**
     * Adds a player to the data tracker.
     *
     * @param name
     *            the name of the player
     * @param stats
     *            the statistics of the player
     * @ensures this = #this union {(name, stats)}
     */
    void addPlayer(String name, Map<String, String> stats);

    /**
     * Removes a player from the data tracker.
     *
     * @param name
     *            the name of the player to remove
     * @ensures this = #this \ {name}
     */
    void removePlayer(String name);

    /**
     * Updates the player stats for a given player.
     *
     * @param name
     *            the name of the player
     * @param stats
     *            the new statistics to update
     * @requires name is in playerStats
     * @ensures this = #this union {(name, stats)}
     */
    void updatePlayerStats(String name, Map<String, String> stats);

    /**
     * Returns whether a player is in the data tracker.
     *
     * @param name
     *            the name of the player
     * @return true if the player is in the data tracker, false otherwise
     * @ensures containsPlayer = (name is in playerStats)
     */
    boolean containsPlayer(String name);

    /**
     * Returns the number of players in the data tracker.
     *
     * @return the number of players in the data tracker
     * @ensures getPlayerCount = |playerStats|
     */
    int getPlayerCount();
}
