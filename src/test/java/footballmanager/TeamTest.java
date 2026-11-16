
package footballmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {

    @Test
    void testTeamCreation() {
        Team team = new Team("Arsenal");

        assertEquals("Arsenal", team.getName());
        assertTrue(team.getPlayers().isEmpty());
    }

    @Test
    void testAddPlayer() {
        Team team = new Team("Arsenal");
        Player player = new FieldPlayer("Saka", 24);

        team.addPlayer(player);

        assertEquals(1, team.getPlayers().size());
        assertTrue(team.getPlayers().contains(player));
    }

    @Test
    void testRemovePlayer() {
        Team team = new Team("Arsenal");
        Player player = new FieldPlayer("Rice", 27);

        team.addPlayer(player);
        team.removePlayer(player);

        assertTrue(team.getPlayers().isEmpty());
    }

    @Test
    void testMultiplePlayers() {
        Team team = new Team("Arsenal");

        team.addPlayer(new FieldPlayer("Saka", 24));
        team.addPlayer(new Goalkeeper("Raya", 30));

        assertEquals(2, team.getPlayers().size());
    }
}
