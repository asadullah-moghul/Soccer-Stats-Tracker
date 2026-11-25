import java.time.LocalDate;

public class Match {

    private final LocalDate date;
    private final String playerName;
    private final String opponent;
    private final int minutesPlayed;
    private final int goals;
    private final int assists;

    public Match(LocalDate date, String playerName, String opponent, int minutesPlayed, int goals, int assists) {
        this.date = date;
        this.playerName = playerName;
        this.opponent = opponent;
        this.minutesPlayed = minutesPlayed;
        this.goals = goals;
        this.assists = assists;
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