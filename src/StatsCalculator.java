import java.util.ArrayList;

public class StatsCalculator {

    public static int totalGoals(ArrayList<Match> matches) {
        int totalGoals = 0;
        for (Match match : matches) {
            totalGoals += match.getGoals();
        }
        return totalGoals;
    }

    public static int totalAssists(ArrayList<Match> matches) {
        int totalAssists = 0;
        for (Match match : matches) {
            totalAssists += match.getAssists();
        }
        return totalAssists;
    }

    public static int totalMinutes(ArrayList<Match> matches) {
        int totalMinutes = 0;
        for (Match match : matches) {
            totalMinutes += match.getMinutesPlayed();
        }
        return totalMinutes;
    }

    public static String summarize(String playerName, ArrayList<Match> matches) {
        int totalGoals = totalGoals(matches);
        int totalAssists = totalAssists(matches);
        int totalMinutes = totalMinutes(matches);

        return String.format("Player: %s\nTotal Goals: %d\nTotal Assists: %d\nTotal Minutes Played: %d",
                playerName, totalGoals, totalAssists, totalMinutes);
    }
}