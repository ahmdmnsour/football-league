public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Team team1 = new Team("Liverpool");
        team1.addPlayer("Mo Salah");
        team1.addPlayer("Van Dijk");

        Team team2 = new Team("Man City");
        team2.addPlayer("Haaland");
        team2.addPlayer("De Bruyne");

        // Create league
        League league = new League("Premier League");
        league.addTeam(team1);
        league.addTeam(team2);

        // Simulate match
        Match match = league.simulateRandomMatch();

        // Display match details
        System.out.println("Match Date & Time: " + match.getMatchDate());
        System.out.println("Home: " + match.getHomeTeam().getTeamName());
        System.out.println("Away: " + match.getAwayTeam().getTeamName());
        System.out.println("Full-Time Score: " + match.getFullTimeScore());
        System.out.println("Winner: " + match.getWinner().getTeamName());
        System.out.println("Goal Scorers: ");
        for (String scorer : match.getGoalScorers()) {
            System.out.println(scorer);
        }
    }
}