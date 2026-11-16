
package footballmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    // 1. Jatekos letrehozasanak tesztelese
    @Test
    void testPlayerCreation() {
        Player player = new FieldPlayer("Saka", 24);

        assertEquals("Saka", player.getName());
        assertEquals(24, player.getAge());
        assertEquals(0, player.getGoals());
    }

    // 2. Golok hozzaadasanak tesztelese
    @Test
    void testAddGoals() {
        Player player = new FieldPlayer("Rice", 27);

        player.addGoals(3);

        assertEquals(3, player.getGoals());
    }

    // 3. Hibas eletkor tesztelese
    @Test
    void testInvalidAge() {
        assertThrows(InvalidPlayerException.class, () -> {
            new FieldPlayer("Saka", -5);
        });
    }

    // 4. Ures nev tesztelese
    @Test
    void testEmptyName() {
        assertThrows(InvalidPlayerException.class, () -> {
            new FieldPlayer("", 25);
        });
    }

    // 5. Factory mukodesenek tesztelese
    @Test
    void testPlayerFactory() {
        Player player = PlayerFactory.createPlayer(
                "Raya", 30, 2
        );

        assertInstanceOf(Goalkeeper.class, player);
    }
}
