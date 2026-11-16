
package footballmanager;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Korabban mentett adatok betoltese
        ArrayList<Team> teams = FileManager.load();

        int valasztas = 0;

        while (valasztas != 8) {

            System.out.println("\n===== FOOTBALL TEAM MANAGER =====");
            System.out.println("1. Uj csapat letrehozasa");
            System.out.println("2. Uj jatekos hozzaadasa");
            System.out.println("3. Csapatok listazasa");
            System.out.println("4. Jatekosok listazasa");
            System.out.println("5. Gol rogzitese");
            System.out.println("6. Jatekosok rendezese");
            System.out.println("7. Jatekos torlese");
            System.out.println("8. Kilepes");

            System.out.print("Valasztas: ");

            if (scanner.hasNextInt()) {
                valasztas = scanner.nextInt();
            } else {
                System.out.println("Kerlek szamot adj meg!");
                scanner.nextLine();
                continue;
            }

            switch (valasztas) {

                case 1:
                    System.out.print("Add meg a csapat nevet: ");
                    scanner.nextLine();

                    String teamName = scanner.nextLine();

                    if (teamName.isBlank()) {
                        System.out.println("A csapat neve nem lehet ures!");
                    } else if (teamName.contains(";")) {
                        System.out.println("A nev nem tartalmazhat pontosvesszot!");
                    } else {
                        Team newTeam = new Team(teamName);
                        teams.add(newTeam);

                        System.out.println("Csapat sikeresen letrehozva!");
                    }
                    break;

                case 2:
                    if (teams.isEmpty()) {
                        System.out.println("Eloszor hozz letre egy csapatot!");
                        break;
                    }

                    System.out.println("Valassz csapatot:");

                    for (int i = 0; i < teams.size(); i++) {
                        System.out.println((i + 1) + ". " +
                                teams.get(i).getName());
                    }

                    System.out.print("Csapat sorszama: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Ervenytelen csapatszam!");
                        scanner.nextLine();
                        break;
                    }

                    int teamIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (teamIndex < 1 || teamIndex > teams.size()) {
                        System.out.println("Ervenytelen csapat!");
                        break;
                    }

                    Team selectedTeam = teams.get(teamIndex - 1);

                    System.out.print("Jatekos neve: ");
                    String playerName = scanner.nextLine();

                    if (playerName.isBlank()) {
                        System.out.println("A nev nem lehet ures!");
                        break;
                    }

                    if (playerName.contains(";")) {
                        System.out.println("A nev nem tartalmazhat pontosvesszot!");
                        break;
                    }

                    System.out.print("Jatekos eletkora: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Az eletkornak szamnak kell lennie!");
                        scanner.nextLine();
                        break;
                    }

                    int age = scanner.nextInt();

                    if (age < 1 || age > 100) {
                        System.out.println("Ervenytelen eletkor!");
                        break;
                    }

                    System.out.println("1. Mezonyjatekos");
                    System.out.println("2. Kapus");
                    System.out.print("Jatekos tipusa: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Ervenytelen tipus!");
                        scanner.nextLine();
                        break;
                    }

                    int type = scanner.nextInt();

                    // Jatekos letrehozasa Factory segitsegevel
                    try {

                        Player newPlayer = PlayerFactory.createPlayer(
                                playerName, age, type
                        );

                        selectedTeam.addPlayer(newPlayer);

                        System.out.println("Jatekos sikeresen hozzaadva!");

                    } catch (InvalidPlayerException e) {

                        System.out.println("Hiba: " + e.getMessage());
                    }

                    break;

                case 3:
                    if (teams.isEmpty()) {
                        System.out.println("Meg nincs letrehozott csapat!");
                    } else {
                        System.out.println("===== CSAPATOK =====");

                        for (Team team : teams) {
                            System.out.println(team.getName());
                        }
                    }
                    break;

                case 4:
                    if (teams.isEmpty()) {
                        System.out.println("Nincs meg csapat!");
                    } else {
                        for (Team team : teams) {
                            team.showPlayers();
                        }
                    }
                    break;

                case 5:
                    if (teams.isEmpty()) {
                        System.out.println("Nincs meg csapat!");
                        break;
                    }

                    System.out.println("Valassz csapatot:");

                    for (int i = 0; i < teams.size(); i++) {
                        System.out.println((i + 1) + ". " +
                                teams.get(i).getName());
                    }

                    System.out.print("Csapat sorszama: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Ervenytelen szam!");
                        scanner.nextLine();
                        break;
                    }

                    int goalTeamIndex = scanner.nextInt() - 1;

                    if (goalTeamIndex < 0 ||
                            goalTeamIndex >= teams.size()) {
                        System.out.println("Ervenytelen csapat!");
                        break;
                    }

                    Team goalTeam = teams.get(goalTeamIndex);

                    if (goalTeam.getPlayers().isEmpty()) {
                        System.out.println("Nincs jatekos a csapatban!");
                        break;
                    }

                    System.out.println("Valassz jatekost:");

                    for (int i = 0;
                         i < goalTeam.getPlayers().size();
                         i++) {

                        System.out.println((i + 1) + ". " +
                                goalTeam.getPlayers().get(i).getName());
                    }

                    System.out.print("Jatekos sorszama: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Ervenytelen szam!");
                        scanner.nextLine();
                        break;
                    }

                    int goalPlayerIndex = scanner.nextInt() - 1;

                    if (goalPlayerIndex < 0 ||
                            goalPlayerIndex >= goalTeam.getPlayers().size()) {
                        System.out.println("Ervenytelen jatekos!");
                        break;
                    }

                    Player goalPlayer =
                            goalTeam.getPlayers().get(goalPlayerIndex);

                    System.out.print("Hany golt szeretnel rogizteni? ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Kerlek szamot adj meg!");
                        scanner.nextLine();
                        break;
                    }

                    int goalAmount = scanner.nextInt();

                    if (goalAmount <= 0) {
                        System.out.println("Legalabb 1 golt kell megadni!");
                        break;
                    }

                    if (goalAmount >
                            Integer.MAX_VALUE - goalPlayer.getGoals()) {
                        System.out.println("Tul nagy golmennyiseg!");
                        break;
                    }

                    goalPlayer.addGoals(goalAmount);

                    System.out.println(
                            "Sikeresen rogzitettel " + goalAmount + " golt!"
                    );

                    System.out.println(
                            goalPlayer.getName() +
                                    " osszes golja: " + goalPlayer.getGoals()
                    );
                    break;

                case 6:
                    if (teams.isEmpty()) {
                        System.out.println("Nincs meg csapat!");
                        break;
                    }

                    for (Team team : teams) {

                        ArrayList<Player> players = team.getPlayers();

                        players.sort((p1, p2) ->
                                Integer.compare(
                                        p2.getGoals(),
                                        p1.getGoals()
                                )
                        );

                        System.out.println("Csapat: " + team.getName());

                        for (Player player : players) {
                            System.out.println(
                                    player.getName() +
                                            " - Golok: " + player.getGoals()
                            );
                        }
                    }
                    break;

                case 7:
                    if (teams.isEmpty()) {
                        System.out.println("Nincs meg csapat!");
                        break;
                    }

                    System.out.println("Valassz csapatot:");

                    for (int i = 0; i < teams.size(); i++) {
                        System.out.println((i + 1) + ". " +
                                teams.get(i).getName());
                    }

                    System.out.print("Csapat sorszama: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Ervenytelen szam!");
                        scanner.nextLine();
                        break;
                    }

                    int deleteTeamIndex = scanner.nextInt() - 1;

                    if (deleteTeamIndex < 0 ||
                            deleteTeamIndex >= teams.size()) {
                        System.out.println("Ervenytelen csapat!");
                        break;
                    }

                    Team deleteTeam = teams.get(deleteTeamIndex);

                    if (deleteTeam.getPlayers().isEmpty()) {
                        System.out.println("Nincs torolheto jatekos!");
                        break;
                    }

                    for (int i = 0;
                         i < deleteTeam.getPlayers().size();
                         i++) {

                        System.out.println((i + 1) + ". " +
                                deleteTeam.getPlayers().get(i).getName());
                    }

                    System.out.print("Torolni kivant jatekos sorszama: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Ervenytelen szam!");
                        scanner.nextLine();
                        break;
                    }

                    int deletePlayerIndex = scanner.nextInt() - 1;

                    if (deletePlayerIndex < 0 ||
                            deletePlayerIndex >= deleteTeam.getPlayers().size()) {
                        System.out.println("Ervenytelen jatekos!");
                        break;
                    }

                    Player deletedPlayer =
                            deleteTeam.getPlayers().get(deletePlayerIndex);

                    deleteTeam.removePlayer(deletedPlayer);

                    System.out.println("Jatekos sikeresen torolve!");
                    break;

                case 8:
                    // Adatok automatikus mentese kilepeskor
                    FileManager.save(teams);

                    System.out.println("Program bezarasa...");
                    break;

                default:
                    System.out.println("Ervenytelen valasztas!");
            }
        }

        scanner.close();
    }
}
