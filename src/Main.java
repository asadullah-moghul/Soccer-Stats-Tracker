import java.util.ArrayList;
import java.io.IOException;

public class Main {
    private static final String DATA_FILE = "data/matches.csv";

    public static void main(String[] args) {
        MatchStorage storage = new MatchStorage(DATA_FILE);
        ArrayList<Match> matches;
        try {
            matches = storage.loadMatches();
        } catch (IOException e) {
            System.out.println("Error loading match data: " + e.getMessage());
            matches = new ArrayList<>();
        }
        ConsoleMenu menu = new ConsoleMenu(storage, matches);
        menu.run();
    }
}