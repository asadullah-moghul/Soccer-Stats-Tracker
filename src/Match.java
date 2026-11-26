import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Match {

    private final LocalDate date;
    private final String playerName;
    private final String opponent;
    private final int minutesPlayed;
    private final int goals;
    private final int assists;
    private static final int CSV_COLUMN_COUNT = 6;

    public Match(LocalDate date, String playerName, String opponent, int minutesPlayed, int goals, int assists) {
        this.date = date;
        this.playerName = playerName;
        this.opponent = opponent;
        this.minutesPlayed = minutesPlayed;
        this.goals = goals;
        this.assists = assists;
    }

    public static Match fromCSV(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length != CSV_COLUMN_COUNT) {
            throw new IllegalArgumentException("Invalid data format: " + e.getMessage());
        }

        try {
            LocalDate date = LocalDate.parse(parts[0].trim());
            String playerName = parts[1].trim();
            String opponent = parts[2].trim();
            int minutesPlayed = Integer.parseInt(parts[3].trim());
            int goals = Integer.parseInt(parts[4].trim());
            int assists = Integer.parseInt(parts[5].trim());

            return new Match(date, playerName, opponent, minutesPlayed, goals, assists);
        } catch (DateTimeParseException | NumberFormatException e) {
            throw new IllegalArgumentException("Invalid data format: " + e.getMessage());
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getOpponent() {
        return opponent;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    @Override
    public String toString() {
        return String.format(date + " - " + playerName + " vs " + opponent + ": " + minutesPlayed + " mins, " + goals + " goals, " + assists + " assists");
    }
}