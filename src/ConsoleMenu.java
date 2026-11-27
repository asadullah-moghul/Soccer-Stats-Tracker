import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleMenu {
    private static final int LOG_MATCH = 1;
    private static final int VIEW_MATCHES = 2;
    private static final int VIEW_PLAYER_STATS = 3;
    private static final int EXIT = 4;

    private final Scanner scanner = new Scanner(System.in);
    private final MatchStorage storage;
    private final ArrayList<Match> matches;

    public ConsoleMenu(MatchStorage storage, ArrayList<Match> matches) {
        this.storage = storage;
        this.matches = matches;
    }

    public void run() {
        while (true) {
            System.out.println("Soccer Stats Tracker Menu:");
            System.out.println(LOG_MATCH + ". Log a new match");
            System.out.println(VIEW_MATCHES + ". View all matches");
            System.out.println(VIEW_PLAYER_STATS + ". View player statistics");
            System.out.println(EXIT + ". Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case LOG_MATCH:
                    logMatch();
                    break;
                case VIEW_MATCHES:
                    showAllMatches();
                    break;
                case VIEW_PLAYER_STATS:
                    showPlayerStats();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void logMatch() {
        try {
            System.out.print("Enter match date (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateInput);

            System.out.print("Enter player name: ");
            String playerName = scanner.nextLine();

            System.out.print("Enter opponent: ");
            String opponent = scanner.nextLine();

            System.out.print("Enter minutes played: ");
            int minutesPlayed = scanner.nextInt();

            System.out.print("Enter goals scored: ");
            int goals = scanner.nextInt();

            System.out.print("Enter assists made: ");
            int assists = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Match match = new Match(date, playerName, opponent, minutesPlayed, goals, assists);
            matches.add(match);
            storage.saveMatches(matches);
            System.out.println("Match logged successfully.");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        } catch (IOException e) {
            System.out.println("Error saving match data: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while logging the match: " + e.getMessage());
        }
    }

    public void showAllMatches() {
        if (matches.isEmpty()) {
            System.out.println("No matches logged yet.");
        } else {
            System.out.println("Logged Matches:");
            for (Match match : matches) {
                System.out.println(match);
            }
        }
    }

    public void showPlayerStats() {
        System.out.print("Enter player name to view statistics: ");
        String playerName = scanner.nextLine();
        ArrayList<Match> playerMatches = StatsCalculator.matchesForPlayer(matches, playerName);
        if (playerMatches.isEmpty()) {
            System.out.println("No matches found for player: " + playerName);
        } else {
            String summary = StatsCalculator.summarize(playerName, playerMatches);
            System.out.println(summary);
        }
    }
}