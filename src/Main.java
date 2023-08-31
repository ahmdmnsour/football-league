import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DB db = new DB();
        ArrayList<League> leagues = new ArrayList<>();
        ArrayList<Integer> teamsIds = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            char choice;
            System.out.println("""
                    press a to display leagues
                    b to display all teams
                    c to display teams of a league
                    d to display matches details
                    e to generate match
                    x to exit""");
            choice = scanner.nextLine().charAt(0);

            if (choice == 'a') {
                leagues = db.getLeagues();
                for (League league : leagues)
                    System.out.println(league.getLeagueId() + " " + league.getLeagueName());
            } else if (choice == 'b') {
                ArrayList<Team> teams = db.getAllTeams();
                for (Team team : teams)
                    System.out.println(team.getTeamId() + " " + team.getTeamName());
            } else if (choice == 'c') {
                System.out.println("Enter league id");
                int leagueId = scanner.nextInt();
                scanner.nextLine();
                ArrayList<Team> teams = db.getTeamsFromLeague(leagueId);
                for (Team team : teams)
                    System.out.println(team.getTeamId() + " " + team.getTeamName());
            } else if (choice == 'd') {
                ArrayList<Match> matches = db.getMatches();
                for (Match match : matches)
                    System.out.println(db.getTeamName(match.getHomeTeamId()) + " " + match.getHomeTeamGoals()
                            + " - " + match.getAwayTeamGoals() + " " + db.getTeamName(match.getAwayTeamId()));
            } else if (choice == 'e') {
                System.out.println("Enter league id");
                int leagueId = scanner.nextInt();
                scanner.nextLine();
                teamsIds = db.getTeamsIdsFromLeague(leagueId);
                Match match = simulateRandomMatch(teamsIds);
                db.insertNewMatch(match);
            } else break;
        }
    }

    public static Match simulateRandomMatch(ArrayList<Integer> teamsIds) {
        Random random = new Random();
        int homeTeamId = teamsIds.get(random.nextInt(teamsIds.size()));
        int awayTeamId = teamsIds.get(random.nextInt(teamsIds.size()));
        while (homeTeamId == awayTeamId) {
            awayTeamId = teamsIds.get(random.nextInt(teamsIds.size()));
        }
        return new Match(homeTeamId, awayTeamId, Timestamp.from(Instant.now()));
    }
}