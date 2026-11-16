
package footballmanager;

public class Goalkeeper extends Player {

    public Goalkeeper(String name, int age) {
        super(name, age);
    }

    @Override
    public String getPosition() {
        return "Kapus";
    }
}
