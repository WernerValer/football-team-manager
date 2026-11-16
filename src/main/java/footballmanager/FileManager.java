
package footballmanager;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "teams.txt";

    public static void save(ArrayList<Team> teams) {
        save(teams, FILE_NAME);
    }

    public static void save(ArrayList<Team> teams, String fileName) {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(fileName))) {

            for (Team team : teams) {
                writer.println("TEAM;" + team.getName());

                for (Player player : team.getPlayers()) {
                    writer.println("PLAYER;" +
                            player.getName() + ";" +
                            player.getAge() + ";" +
                            player.getPosition() + ";" +
                            player.getGoals());
                }
            }

            if (writer.checkError()) {
                throw new IOException("Hiba a fajl irasa kozben!");
            }

            System.out.println("Adatok sikeresen mentve!");

        } catch (IOException e) {
            System.out.println("Hiba a mentes soran: " + e.getMessage());
        }
    }

    public static ArrayList<Team> load() {
        return load(FILE_NAME);
    }

    public static ArrayList<Team> load(String fileName) {

        ArrayList<Team> teams = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            return teams;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;
            Team currentTeam = null;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(";", -1);

                if (data[0].equals("TEAM")) {

                    if (data.length != 2) {
                        throw new IllegalArgumentException("Hibas csapatadat!");
                    }

                    currentTeam = new Team(data[1]);
                    teams.add(currentTeam);

                } else if (data[0].equals("PLAYER")
                        && currentTeam != null) {

                    if (data.length != 5) {
                        throw new IllegalArgumentException("Hibas jatekosadat!");
                    }

                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String position = data[3];
                    int goals = Integer.parseInt(data[4]);

                    int type;

                    if (position.equals("Kapus")) {
                        type = 2;
                    } else if (position.equals("Mezonyjatekos")) {
                        type = 1;
                    } else {
                        throw new InvalidPlayerException(
                                "Ismeretlen jatekosposzt: " + position
                        );
                    }

                    Player player = PlayerFactory.createPlayer(
                            name, age, type
                    );

                    player.setGoals(goals);
                    currentTeam.addPlayer(player);

                } else {
                    throw new IllegalArgumentException(
                            "Ismeretlen vagy hibas adatsor!"
                    );
                }
            }

            System.out.println("Adatok sikeresen betoltve!");

        } catch (IOException | RuntimeException e) {
            System.out.println("Hiba a betoltes soran: " + e.getMessage());
            teams.clear();
        }

        return teams;
    }
}
