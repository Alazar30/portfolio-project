package components.fpldatatracker;

/**
 * {@code FPLDataTrackerKernel} enhanced with secondary methods.
 */
public interface FPLDataTracker extends FPLDataTrackerKernel {
    /**
     * Returns the player stats for a given player.
     *
     * @param name the name of the player
     * @return the statistics of the player
     * @requires name is in playerStats
     * @ensures getPlayerStats = playerStats[name]
     */
    Map<String, String> getPlayerStats(String name);

    /**
     * Returns the top scorers in the league.
     *
     * @return a map containing the top scorers and their statistics
     * @ensures getTopScorers contains the highest-scoring players
     */
    Map<String, String> getTopScorers();

    /**
     * Returns the top assisters in the league.
     *
     * @return a map containing the top assisters and their statistics
     * @ensures getTopAssisters contains the players with the most assists
     */
    Map<String, String> getTopAssisters();

    /**
     * Returns the best players by position.
     *
     * @return a map categorizing the best players by position
     * @ensures getBestPlayersByPosition groups players based on their positions
     */
    Map<String, String> getBestPlayersByPosition();
}