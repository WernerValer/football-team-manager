
package footballmanager;

public abstract class Player {

    private String name;
    private int age;
    private int goals;

    public Player(String name, int age) {

        if (name == null || name.isBlank()) {
            throw new InvalidPlayerException(
                    "A jatekos neve nem lehet ures!"
            );
        }

        if (name.contains(";")) {
            throw new InvalidPlayerException(
                    "A jatekos neve nem tartalmazhat pontosvesszot!"
            );
        }

        if (age < 1 || age > 100) {
            throw new InvalidPlayerException(
                    "A jatekos eletkora 1 es 100 kozott lehet!"
            );
        }

        this.name = name;
        this.age = age;
        this.goals = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGoals() {
        return goals;
    }

    public void addGoal() {
        addGoals(1);
    }

    public void addGoals(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "A golok szamanak pozitivnak kell lennie!"
            );
        }

        if (amount > Integer.MAX_VALUE - goals) {
            throw new IllegalArgumentException(
                    "Tul nagy golmennyiseg!"
            );
        }

        goals += amount;
    }

    public void setGoals(int goals) {

        if (goals < 0) {
            throw new IllegalArgumentException(
                    "A golok szama nem lehet negativ!"
            );
        }

        this.goals = goals;
    }

    public abstract String getPosition();

    public void showInfo() {
        System.out.println("Nev: " + name);
        System.out.println("Eletkor: " + age);
        System.out.println("Golok: " + goals);
        System.out.println("Poszt: " + getPosition());
    }
}
