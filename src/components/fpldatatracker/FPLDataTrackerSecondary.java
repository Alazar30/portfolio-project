import components.map.Map;
import components.map.Map1L;

/**
 * Layered implementations of secondary methods for FPLDataTracker.
 */
public abstract class FPLDataTrackerSecondary implements FPLDataTracker {

    /*
     * Common methods (from Object) -------------------------------------------
     */

    @Override
    public String toString() {
        String result = "";

        Map<String, Map<String, String>> playerStats = new Map1L<>();
        for (Map.Pair<String, Map<String, String>> player : playerStats) {
            result += player.key() + ": " + player.value() + "\n";
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (this == obj) {
            FPLDataTrackerSecondary other = (FPLDataTrackerSecondary) obj;
            Map<String, Map<String, String>> playerStats = new Map1L<>();
            Map<String, Map<String, String>> otherPlayerStats = new Map1L<>();
            result = playerStats.equals(otherPlayerStats);
        }

        return result;
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    /**
     * Returns the player stats for a given player.
     *
     *
     * @param name
     *            the name of the player
     * @return the statistics of the player
     * @requires name is in playerStats
     * @ensures getPlayerStats = playerStats[name]
     */
    @Override
    public Map<String, String> getPlayerStats(String name) {
        Map<String, Map<String, String>> playerStats = new Map1L<>();
        return playerStats.value(name);
    }

    /**
     * Returns the top scorer in the league.
     *
     * @return a map containing the top scorer and their statistics
     * @ensures getTopScorer contains the highest-scoring players
     */
    @Override
    public Map<String, String> getTopScorer() {
        Map<String, Map<String, String>> playerStats = new Map1L<>();
        Map<String, String> topScorer = new Map1L<>();
        int maxGoals = 0;

        for (Map.Pair<String, Map<String, String>> player : playerStats) {
            int goals = Integer.parseInt(player.value().value("Goals"));
            if (goals > maxGoals) {
                maxGoals = goals;
                topScorer = player.value();
            }
        }

        return topScorer;
    }

    /**
     * Returns the top assister in the league.
     *
     * @return a map containing the top assister and their statistics
     * @ensures getTopAssister contains the player with the most assists
     */
    @Override
    public Map<String, String> getTopAssister() {
        Map<String, Map<String, String>> playerStats = new Map1L<>();
        Map<String, String> topAssister = new Map1L<>();
        int maxAssists = 0;

        for (Map.Pair<String, Map<String, String>> player : playerStats) {
            int assists = Integer.parseInt(player.value().value("Assists"));
            if (assists > maxAssists) {
                maxAssists = assists;
                topAssister = player.value();
            }
        }

        return topAssister;
    }

}
