
package footballmanager;

public class FieldPlayer extends Player {

    public FieldPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public String getPosition() {
        return "Mezonyjatekos";
    }
}

