
package footballmanager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {

    @TempDir
    Path tempDir;

    @Test
    void testSaveAndLoad() {

        String testFile = tempDir.resolve("test-teams.txt").toString();

        ArrayList<Team> teams = new ArrayList<>();
        Team arsenal = new Team("Arsenal");

        Player saka = new FieldPlayer("Saka", 24);
        saka.addGoals(5);

        Player raya = new Goalkeeper("Raya", 30);

        arsenal.addPlayer(saka);
        arsenal.addPlayer(raya);
        teams.add(arsenal);

        FileManager.save(teams, testFile);

        ArrayList<Team> loadedTeams = FileManager.load(testFile);

        assertEquals(1, loadedTeams.size());

        Team loadedTeam = loadedTeams.get(0);

        assertEquals("Arsenal", loadedTeam.getName());
        assertEquals(2, loadedTeam.getPlayers().size());

        Player loadedSaka = loadedTeam.getPlayers().get(0);
        Player loadedRaya = loadedTeam.getPlayers().get(1);

        assertEquals("Saka", loadedSaka.getName());
        assertEquals(5, loadedSaka.getGoals());
        assertInstanceOf(FieldPlayer.class, loadedSaka);

        assertEquals("Raya", loadedRaya.getName());
        assertInstanceOf(Goalkeeper.class, loadedRaya);
    }
}
