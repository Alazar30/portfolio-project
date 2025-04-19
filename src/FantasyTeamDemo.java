import components.map.Map;
import components.map.Map1L;

public final class FantasyTeamDemo {

    public static void main(String[] args) {
        FPLDataTracker tracker = new FPLDataTracker1();

        Map<String, String> sakaStats = new Map1L<>();
        sakaStats.add("Goals", "12");
        sakaStats.add("Assists", "8");

        Map<String, String> haalandStats = new Map1L<>();
        haalandStats.add("Goals", "20");
        haalandStats.add("Assists", "5");

        tracker.addPlayer("Saka", sakaStats);
        tracker.addPlayer("Haaland", haalandStats);

        System.out.println("Top Scorer Stats: " + tracker.getTopScorer());
    }
}
