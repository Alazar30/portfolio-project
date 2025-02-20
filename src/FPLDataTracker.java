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
    private Map<String, String> playerStats;

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

    @Override
    public final void addPlayer(String name, Map<K, V> stats) {
        this.playerStats.add(name, stats);
    }

    @Override
    public final void removePlayer(String name) {
        this.playerStats.remove(name);
    }

    @Override
    public final void updatePlayerStats(String name, Map<K, V> stats) {
        this.playerStats.replaceValue(name, stats);
    }

    @Override
    public final boolean containsPlayer(String name) {
        return this.playerStats.hasKey(name);
    }

    @Override
    public final int getPlayerCount() {
        return this.playerStats.size();
    }

    /**
     * Secondary Methods.
     */

    @Override
    public final Map.Pair<K, V> getPlayerStats(String name) {
        return this.playerStats.value(name);
    }

    @Override
    public final String getTopScorers(String name) {
        return this.playerStats.value(name);
    }

    @Override
    public final String getTopAssisters(String name) {
        return this.playerStats.value(name);
    }

    @Override
    public final String getBestPlayersByPosition(String name) {

    }

    /**
     * Main Method.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleWriter1L out = new SimpleWriter1L();

        FPLDataTracker tracker = new FPLDataTracker();

        tracker.addPlayer("Alazar", new Map.Pair<>("Goals", "10"));
        tracker.addPlayer("Hazard", new Map.Pair<>("Goals", "20"));
        tracker.addPlayer("Palmer", new Map.Pair<>("Goals", "30"));

        out.println(tracker.getPlayerStats("Alazar"));
        out.println(tracker.getPlayerStats("Hazard"));
        out.println(tracker.getPlayerStats("Palmer"));
        out.println(tracker.getPlayerCount());

        tracker.updatePlayerStats("Alazar", new Map.Pair<>("Goals", "15"));
        out.println(tracker.getPlayerStats("Alazar"));

        tracker.removePlayer("Hazard");
        out.println(tracker.getPlayerCount());
    }
}
