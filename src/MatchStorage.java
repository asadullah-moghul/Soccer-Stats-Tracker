import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MatchStorage {
    private final File csvFile;

    public MatchStorage(String csvPath) {
        this.csvFile = new File(csvPath);
    }

    public ArrayList<Match> loadMatches() throws IOException {
        ArrayList<Match> matches = new ArrayList<>();

        if (!csvFile.exists()) {
            return matches;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Skip header line
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }
                try {
                    Match match = Match.fromCSV(line);
                    matches.add(match);
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        }
        return matches;
    }
}