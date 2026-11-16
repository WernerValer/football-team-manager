
package footballmanager;

public class PlayerFactory {

    public static Player createPlayer(String name, int age, int type) {

        if (type == 1) {
            return new FieldPlayer(name, age);
        } else if (type == 2) {
            return new Goalkeeper(name, age);
        } else {
            throw new InvalidPlayerException(
                    "Ervenytelen jatekos tipus!"
            );
        }
    }
}
