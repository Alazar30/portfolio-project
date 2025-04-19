import components.map.Map;
import components.map.Map1L;
import components.simplewriter.SimpleWriter1L;

public class PlayerStatsViewer {

    private FPLDataTracker tracker;

    public PlayerStatsViewer(FPLDataTracker tracker) {
        this.tracker = tracker;
    }

    public void displayPlayer(String name) {
        Simplewriter out = new SimpleWriter1L();

        if (this.tracker.containsPlayer(name)) {
            Map<String, String> stats = this.tracker.getPlayerStats(name);
            out.println(name + " stats: " + stats);
        } else {
            out.println(name + " not found.");
        }
    }

    public static void main(String[] args) {
        FPLDataTracker tracker = new FPLDataTracker1();

        Map<String, String> palmerStats = new Map1L<>();
        sonStats.add("Goals", "10");
        sonStats.add("Assists", "9");
        tracker.addPlayer("Palmer", palmerStats);

        PlayerStatsViewer viewer = new PlayerStatsViewer(tracker);
        viewer.displayPlayer("Palmer");
        viewer.displayPlayer("Ronaldo");
    }
}
