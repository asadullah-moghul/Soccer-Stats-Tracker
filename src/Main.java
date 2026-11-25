import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Match> matches = new ArrayList<>();

        matches.add(new Match(LocalDate.of(2026, 9, 6), "Jude Bellingham", "Real Madrid", 90, 2, 0));
        matches.add(new Match(LocalDate.of(2026, 10, 25), "Michael Olise", "Bayern Munich", 75, 0, 1));
        matches.add(new Match(LocalDate.of(2026, 11, 13), "Asadullah Moghul", "Aston Villa", 90, 1, 1));

        for (Match match : matches) {
            System.out.println(match);
        }
    }
}