import java.util.ArrayList;
import java.io.IOException;

public class Main {
    private static final String DATA_FILE = "data/matches.csv";

    public static void main(String[] args) {
        MatchStorage storage = new MatchStorage(DATA_FILE);
        try {
            ArrayList<Match> matches = storage.loadMatches();
            if (matches.isEmpty()) {
                System.out.println("No matches logged yet.");
            } else {
                System.out.println("Loaded " + matches.size() + " matches:");
            }
            for (Match match : matches) {
                System.out.println(match);
            }
            System.out.println();
            for (String name : StatsCalculator.playerNames(matches)) {
                ArrayList<Match> playerMatches = StatsCalculator.matchesForPlayer(matches, name);
                String summary = StatsCalculator.summarize(name, playerMatches);
                System.out.println(summary);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error loading match data: " + e.getMessage());
        }
    }
}