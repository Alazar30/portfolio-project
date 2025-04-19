package components.fpldatatracker;

/**
 * {@code FPLDataTrackerKernel} enhanced with secondary methods.
 */
public interface FPLDataTracker extends FPLDataTrackerKernel {
    /**
     * Returns the player stats for a given player.
     *
     * @param name
     *            the name of the player
     * @return the statistics of the player
     * @requires name is in playerStats
     * @ensures getPlayerStats = playerStats[name]
     */
    Map<String, String> getPlayerStats(String name);

    /**
     * Returns the top scorer in the league.
     *
     * @return a map containing the top scorer and their statistics
     * @ensures getTopScorer contains the highest-scoring player
     */
    Map<String, String> getTopScorer();

    /**
     * Returns the top assister in the league.
     *
     * @return a map containing the top assister and their statistics
     * @ensures getTopAssister contains the player with the most assists
     */
    Map<String, String> getTopAssister();
}