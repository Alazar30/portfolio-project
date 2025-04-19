import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;

/**
 * JUnit test fixture for {@code FPLDataTracker}'s secondary and common methods.
 *
 * @author Alazar Alemayehu
 */
public abstract class FPLDataTrackerTest {

    // Testing for GetPlayerStats Method
    @Test
    public void testGetPlayerStatsBoundary() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        stats.add("Goals", "0");
        stats.add("Assists", "0");

        tracker.addPlayer("TestPlayer", stats);
        Map<String, String> result = tracker.getPlayerStats("TestPlayer");

        assertEquals(stats, result);
    }

    @Test
    public void testGetPlayerStatsRoutine() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        stats.add("Goals", "5");
        stats.add("Assists", "3");

        tracker.addPlayer("Saka", stats);
        Map<String, String> result = tracker.getPlayerStats("Saka");

        assertEquals(stats, result);
    }

    @Test
    public void testGetPlayerStatsChallenging() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        stats.add("Goals", "99");
        stats.add("Assists", "100");

        tracker.addPlayer("SuperPlayer", stats);
        Map<String, String> result = tracker.getPlayerStats("SuperPlayer");

        assertEquals(stats, result);
    }

    // Testing for GetTopScorer Method
    @Test
    public void testGetTopScorerBoundary() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        stats.add("Goals", "0");
        stats.add("Assists", "0");

        tracker.addPlayer("TestPlayer", stats);
        Map<String, String> result = tracker.getTopScorer();

        assertEquals(stats, result);
    }

    @Test
    public void testGetTopScorerRoutine() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats1 = new Map1L<>();
        stats1.add("Goals", "3");
        stats1.add("Assists", "1");
        tracker.addPlayer("PlayerA", stats1);

        Map<String, String> stats2 = new Map1L<>();
        stats2.add("Goals", "5");
        stats2.add("Assists", "2");
        tracker.addPlayer("PlayerB", stats2);

        assertEquals(stats2, tracker.getTopScorer());
    }

    @Test
    public void testGetTopScorerChallenging() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats1 = new Map1L<>();
        stats1.add("Goals", "10");
        stats1.add("Assists", "5");
        tracker.addPlayer("PlayerA", stats1);

        Map<String, String> stats2 = new Map1L<>();
        stats2.add("Goals", "8");
        stats2.add("Assists", "7");
        tracker.addPlayer("PlayerB", stats2);

        Map<String, String> stats3 = new Map1L<>();
        stats2.add("Goals", "30");
        stats2.add("Assists", "25");
        tracker.addPlayer("PlayerC", stats2);

        assertEquals(stats3, tracker.getTopScorer());
    }

    // Testing for GetTopAssister Method
    @Test
    public void testGetTopAssisterBoundary() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        stats.add("Goals", "0");
        stats.add("Assists", "1");
        tracker.addPlayer("Solo", stats);

        assertEquals(stats, tracker.getTopAssister());
    }

    @Test
    public void testGetTopAssisterRoutine() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats1 = new Map1L<>();
        stats1.add("Goals", "2");
        stats1.add("Assists", "3");
        tracker.addPlayer("PlayerA", stats1);

        Map<String, String> stats2 = new Map1L<>();
        stats2.add("Goals", "4");
        stats2.add("Assists", "6");
        tracker.addPlayer("PlayerB", stats2);

        assertEquals(stats2, tracker.getTopAssister());
    }

    @Test
    public void testGetTopAssisterChallenging() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats1 = new Map1L<>();
        stats1.add("Goals", "2");
        stats1.add("Assists", "5");
        tracker.addPlayer("PlayerA", stats1);

        Map<String, String> stats2 = new Map1L<>();
        stats2.add("Goals", "3");
        stats2.add("Assists", "7");
        tracker.addPlayer("PlayerB", stats2);

        Map<String, String> stats3 = new Map1L<>();
        stats2.add("Goals", "3");
        stats2.add("Assists", "25");
        tracker.addPlayer("PlayerC", stats2);

        assertEquals(stats3, tracker.getTopAssister());
    }

    // Testing for toString Method
    @Test
    public void testToStringBoundary() {
        FPLDataTracker tracker = new FPLDataTracker1();

        assertEquals("", tracker.toString());
    }

    @Test
    public void testToStringRoutine() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        stats.add("Goals", "2");
        stats.add("Assists", "1");
        tracker.addPlayer("Saka", stats);

        String expected = "Saka: {(Goals, 2), (Assists, 1)}";
        assertEquals(expected, tracker.toString());
    }

    @Test
    public void testToStringChallenging() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> statsA = new Map1L<>();
        Map<String, String> statsB = new Map1L<>();
        statsA.add("Goals", "3");
        statsA.add("Assists", "2");
        statsB.add("Goals", "1");
        statsB.add("Assists", "4");
        tracker.addPlayer("PlayerA", statsA);
        tracker.addPlayer("PlayerB", statsB);

        String expected = "PlayerA: {(Goals, 3), (Assists, 2)}, PlayerB: {(Goals, 1), (Assists, 4)}";
        assertEquals(expected, tracker.toString());
    }

    // Testing for Equals Method
    @Test
    public void testEqualsBoundary() {
        FPLDataTracker tracker1 = new FPLDataTracker1();
        FPLDataTracker tracker2 = new FPLDataTracker1();
        assertEquals(true, tracker1.equals(tracker2));
    }

    @Test
    public void testEqualsRoutine() {
        FPLDataTracker tracker1 = new FPLDataTracker1();
        FPLDataTracker tracker2 = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        stats.add("Goals", "5");
        stats.add("Assists", "3");

        tracker1.addPlayer("Saka", stats);
        tracker2.addPlayer("Saka", stats);

        assertEquals(true, tracker1.equals(tracker2));
    }

    @Test
    public void testEqualsChallenging() {
        FPLDataTracker tracker1 = new FPLDataTracker1();
        FPLDataTracker tracker2 = new FPLDataTracker1();
        Map<String, String> statsA = new Map1L<>();
        Map<String, String> statsB = new Map1L<>();
        statsA.add("Goals", "3");
        statsA.add("Assists", "2");
        statsB.add("Goals", "1");
        statsB.add("Assists", "4");
        tracker1.addPlayer("PlayerA", statsA);
        tracker2.addPlayer("PlayerB", statsB);

        assertEquals(false, tracker1.equals(tracker2));
    }
}
