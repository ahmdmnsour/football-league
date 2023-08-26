import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DB db = new DB();
        db.listLeagues();

//        List<League> leagues = new ArrayList<>();
//
//
//        League league = new League("Premier League");
//        league.addTeam(team1);
//        league.addTeam(team2);
//
//        Match match = league.simulateRandomMatch();
//
//        System.out.println("Match Date & Time: " + match.getMatchDate());
//        System.out.println("Home: " + match.getHomeTeam().getTeamName());
//        System.out.println("Away: " + match.getAwayTeam().getTeamName());
//        System.out.println("Full-Time Score: " + match.getFullTimeScore());
//        System.out.println("Winner: " + match.getWinner().getTeamName());
//        System.out.println("Goal Scorers: ");
//        for (Player scorer : match.getGoalScorers()) {
//            System.out.println(scorer.getName());
//        }
    }
}