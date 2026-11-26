import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class MatchStorage {
    private final File csvFile;
    private static final String CSV_HEADER = "date,player name,opponent,minutes played,goals,assists";

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

    public void saveMatches(ArrayList<Match> matches) throws IOException {
        File parentDir = csvFile.getParentFile();
        if (parentDir != null) {
            parentDir.mkdirs();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            bw.write(CSV_HEADER);
            bw.newLine();
            for (Match match : matches) {
                bw.write(match.toCSV());
                bw.newLine();
            }
        }
    }
}