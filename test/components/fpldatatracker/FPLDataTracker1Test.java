import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;

/**
 * JUnit test fixture for {@code FPLDataTracker}'s constructor and kernel
 * methods.
 *
 * @author Alazar Alemayehu
 */
public abstract class FPLDataTracker1Test {

    // Testing for Constructor
    @Test
    public void testConstructor() {
        FPLDataTracker tracker = new FPLDataTracker1();
        assertEquals(0, tracker.getPlayerCount());
    }

    // Testing for AddPlayer Method
    @Test
    public void testAddPlayerBoundary() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> emptyStats = new Map1L<>();
        tracker.addPlayer("PlayerWithNoStats", emptyStats);
        assertEquals(true, tracker.containsPlayer("PlayerWithNoStats"));
        assertEquals(1, tracker.getPlayerCount());
    }

    @Test
    public void testAddPlayerRoutine() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        stats.add("goals", "3");
        stats.add("assists", "1");
        tracker.addPlayer("Saka", stats);
        assertEquals(true, tracker.containsPlayer("Saka"));
        assertEquals(1, tracker.getPlayerCount());
    }

    @Test
    public void testAddPlayerChallenging() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> statsA = new Map1L<>();
        Map<String, String> statsB = new Map1L<>();
        statsA.add("goals", "2");
        statsB.add("assists", "4");
        tracker.addPlayer("PlayerA", statsA);
        tracker.addPlayer("PlayerB", statsB);
        assertEquals(2, tracker.getPlayerCount());
    }

    // Testing for RemovePlayer Method
    @Test
    public void testRemovePlayerBoundary() {
        FPLDataTracker tracker = new FPLDataTracker1();
        tracker.removePlayer("NonExistentPlayer");
        assertEquals(false, tracker.containsPlayer("NonExistentPlayer"));
        assertEquals(0, tracker.getPlayerCount());
    }

    @Test
    public void testRemovePlayerRoutine() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        stats.add("goals", "5");
        tracker.addPlayer("Son", stats);
        tracker.removePlayer("Son");
        assertEquals(false, tracker.containsPlayer("Son"));
        assertEquals(0, tracker.getPlayerCount());
    }

    @Test
    public void testRemovePlayerChallenging() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> statsA = new Map1L<>();
        Map<String, String> statsB = new Map1L<>();
        statsA.add("goals", "2");
        statsB.add("assists", "4");
        tracker.addPlayer("PlayerA", statsA);
        tracker.addPlayer("PlayerB", statsB);
        tracker.removePlayer("PlayerA");
        assertEquals(false, tracker.containsPlayer("PlayerA"));
        assertEquals(1, tracker.getPlayerCount());
    }

    // Testing for UpdatePlayerStats Method
    @Test
    public void testUpdatePlayerStatsBoundary() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> initialStats = new Map1L<>();
        initialStats.add("goals", "1");
        tracker.addPlayer("KDB", initialStats);
        Map<String, String> emptyStats = new Map1L<>();
        tracker.updatePlayerStats("KDB", emptyStats);
        Map<String, String> actualStats = tracker.getStats("KDB");
        assertEquals(0, actualStats.size());
    }

    @Test
    public void testUpdatePlayerStatsRoutine() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> initialStats = new Map1L<>();
        initialStats.add("goals", "2");
        initialStats.add("assists", "1");
        tracker.addPlayer("KDB", initialStats);
        Map<String, String> newStats = new Map1L<>();
        newStats.add("goals", "5");
        newStats.add("cleanSheets", "2");
        tracker.updatePlayerStats("KDB", newStats);
        Map<String, String> actualStats = tracker.getStats("KDB");
        assertEquals("5", actualStats.get("goals"));
        assertEquals("2", actualStats.get("cleanSheets"));
    }

    @Test
    public void testUpdatePlayerStatsChallenging() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> initialStats = new Map1L<>();
        initialStats.add("goals", "3");
        tracker.addPlayer("PlayerX", initialStats);
        Map<String, String> conflictingStats = new Map1L<>();
        conflictingStats.add("goals", "0");
        conflictingStats.add("assists", "3");
        tracker.updatePlayerStats("PlayerX", conflictingStats);
        Map<String, String> actualStats = tracker.getStats("PlayerX");
        assertEquals("0", actualStats.get("goals"));
        assertEquals("3", actualStats.get("assists"));
    }

    // Testing for ContainsPlayer Method
    @Test
    public void testContainsPlayerBoundary() {
        FPLDataTracker tracker = new FPLDataTracker1();
        assertEquals(false, tracker.containsPlayer("NonExistentPlayer"));
    }

    @Test
    public void testContainsPlayerRoutine() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        tracker.addPlayer("Salah", stats);
        assertEquals(true, tracker.containsPlayer("Salah"));
    }

    @Test
    public void testContainsPlayerChallenging() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> stats = new Map1L<>();
        tracker.addPlayer("Salah", stats);
        tracker.addPlayer("Mane", stats);
        assertEquals(false, tracker.containsPlayer("Haaland"));
    }

    // Testing for GetPlayerCount Method
    @Test
    public void testGetPlayerCountBoundary() {
        FPLDataTracker tracker = new FPLDataTracker1();
        assertEquals(0, tracker.getPlayerCount());
    }

    @Test
    public void testGetPlayerCountRoutine() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> statsA = new Map1L<>();
        Map<String, String> statsB = new Map1L<>();
        tracker.addPlayer("PlayerA", statsA);
        tracker.addPlayer("PlayerB", statsB);
        assertEquals(2, tracker.getPlayerCount());
    }

    @Test
    public void testGetPlayerCountChallenging() {
        FPLDataTracker tracker = new FPLDataTracker1();
        Map<String, String> statsA = new Map1L<>();
        Map<String, String> statsB = new Map1L<>();
        tracker.addPlayer("PlayerA", statsA);
        tracker.addPlayer("PlayerB", statsB);
        tracker.removePlayer("PlayerA");
        assertEquals(1, tracker.getPlayerCount());
    }
}
