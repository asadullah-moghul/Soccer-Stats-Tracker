import java.time.LocalDate;
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
        } catch (IOException e) {
            System.err.println("Error loading match data: " + e.getMessage());
        }
    }
}