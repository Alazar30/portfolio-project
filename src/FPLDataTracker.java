import components.map.Map;
import components.map.Map1L;
import components.simplewriter.SimpleWriter1L;

/**
 * Proof of Concept implementation for project that tracks player data for the
 * Fantasy Premier League.
 *
 * @author Alazar Alemayehu
 */
public class FPLDataTracker {
    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Example field representing player data storage.
     */
    private Map<String, Map<String, String>> playerStats;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.playerStats = new Map1L<>();

    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument Constructor.
     */
    public FPLDataTracker() {
        this.createNewRep();
    }

    /**
     * Kernal Methods.
     */

    /**
     * Adds a player to the data tracker.
     *
     * @param name
     * @param stats
     */
    public final void addPlayer(String name, Map<String, String> stats) {
        this.playerStats.add(name, stats);
    }

    /**
     * Removes a player from the data tracker.
     *
     * @param name
     */
    public final void removePlayer(String name) {
        this.playerStats.remove(name);
    }

    /**
     * Updates the player stats for a given player.
     *
     * @param name
     * @param stats
     */
    public final void updatePlayerStats(String name,
            Map<String, String> stats) {
        this.playerStats.replaceValue(name, stats);
    }

    /**
     * Returns whether a player is in the data tracker.
     *
     * @param name
     * @return boolean
     */
    public final boolean containsPlayer(String name) {
        return this.playerStats.hasKey(name);
    }

    /**
     * Returns the number of players in the data tracker.
     *
     * @return int
     */
    public final int getPlayerCount() {
        return this.playerStats.size();
    }

    /**
     * Secondary Methods.
     */

    /**
     * Returns the player stats for a given player.
     *
     * @param name
     * @return Map<String, String>
     */
    public final Map<String, String> getPlayerStats(String name) {
        return this.playerStats.value(name);
    }

    /**
     * Returns the top scorers in the league.
     *
     * @param name
     * @return Map<String, String>
     */
    public final Map<String, String> getTopScorers(String name) {
        return this.playerStats.value(name);
    }

    /**
     * Returns the top assisters in the league.
     *
     * @param name
     * @return Map<String, String>
     */
    public final Map<String, String> getTopAssisters(String name) {
        return this.playerStats.value(name);
    }

    /**
     * Returns the best players by position.
     *
     * @param name
     * @return Map<String, String>
     */
    public final Map<String, String> getBestPlayersByPosition(String name) {

    }

    /**
     * Main Method.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleWriter1L out = new SimpleWriter1L();

        FPLDataTracker tracker = new FPLDataTracker();

        Map<String, String> alazarStats = new Map1L<>();
        alazarStats.add("Goals", "10");
        tracker.addPlayer("Alazar", alazarStats);

        Map<String, String> hazardStats = new Map1L<>();
        hazardStats.add("Goals", "20");
        tracker.addPlayer("Hazard", hazardStats);

        Map<String, String> palmerStats = new Map1L<>();
        palmerStats.add("Goals", "30");
        tracker.addPlayer("Palmer", palmerStats);

        out.println("Alazar Stats: " + tracker.getPlayerStats("Alazar"));
        out.println("Hazard Stats: " + tracker.getPlayerStats("Hazard"));
        out.println("Palmer Stats: " + tracker.getPlayerStats("Palmer"));
        out.println("\nTotal Amount of Players: " + tracker.getPlayerCount());

        Map<String, String> alazarNewStats = new Map1L<>();
        alazarNewStats.add("Goals", "15");
        tracker.updatePlayerStats("Alazar", alazarNewStats);
        out.println(
                "\nUpdated Alazar Stats: " + tracker.getPlayerStats("Alazar"));

        tracker.removePlayer("Hazard");
        out.println("\nUpdated Total Amount of Players after Removing Hazard: "
                + tracker.getPlayerCount());

        out.close();
    }
}
