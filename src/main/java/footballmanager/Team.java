
package footballmanager;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void showPlayers() {
        System.out.println("Csapat: " + name);

        for (Player player : players) {
            player.showInfo();
            System.out.println("----------");
        }
    }
}
