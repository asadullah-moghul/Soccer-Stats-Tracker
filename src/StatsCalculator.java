import java.util.ArrayList;

public class StatsCalculator {

    public static ArrayList<Match> matchesForPlayer(ArrayList<Match> matches, String playerName) {
        ArrayList<Match> playerMatches = new ArrayList<>();
        for (Match match : matches) {
            if (match.getPlayerName().equalsIgnoreCase(playerName)) {
                playerMatches.add(match);
            }
        }
        return playerMatches;
    }

    public static ArrayList<String> playerNames(ArrayList<Match> matches) {
        ArrayList<String> names = new ArrayList<>();
        for (Match match : matches) {
            String playerName = match.getPlayerName();
            if (!names.contains(playerName)) {
                names.add(playerName);
            }
        }
        return names;
    }

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

    public static double perGame(int total, int matchesPlayed) {
        if (matchesPlayed == 0) {
            return 0.0;
        }
        return (double) total / matchesPlayed;
    }

    public static String summarize(String playerName, ArrayList<Match> matches) {
        int matchesPlayed = matches.size();
        int totalGoals = totalGoals(matches);
        int totalAssists = totalAssists(matches);
        int totalMinutes = totalMinutes(matches);

        return String.format(
                "Player: %s\nMatches Played: %d\nTotal Goals: %d\nTotal Assists: %d\nTotal Minutes Played: %d\nGoals per Game: %.2f\nAssists per Game: %.2f",
                playerName,
                matchesPlayed,
                totalGoals,
                totalAssists,
                totalMinutes,
                perGame(totalGoals, matchesPlayed),
                perGame(totalAssists, matchesPlayed)
        );
    }
}