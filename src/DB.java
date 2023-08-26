import java.sql.*;

public class DB {
    String jdbcUrl = "jdbc:postgresql://localhost:5432/football";
    String username = "postgres";
    String password = "admin";
    static Connection connection;

    public DB() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            listLeagues();
            listTeamsInLeague(1); // Assuming league ID 1
            listPlayersInTeam(1); // Assuming team ID 1
            listPlayedMatches();
            displayMatchInfo(1); // Assuming match ID 1

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listLeagues() throws SQLException {
        String query = "SELECT league_name FROM leagues";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next())
                System.out.println(resultSet.getString("league_name"));
        }
    }

    private void listTeamsInLeague(int leagueId) throws SQLException {
        String query = "SELECT t.team_name FROM teams t " +
                "INNER JOIN team_league tl ON t.team_id = tl.team_id " +
                "WHERE tl.league_id = " + leagueId;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String name = resultSet.getString("team_name");
                System.out.println(name);
            }

        }
    }

    private void listPlayersInTeam(int teamId) throws SQLException {
        String query = "SELECT name FROM players WHERE team_id = " + teamId;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
            }
        }
    }

    private void listPlayedMatches() throws SQLException {
        String query = "SELECT * FROM matches";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("match_id");
                int team1Id = resultSet.getInt("home_team_id");
                int team2Id = resultSet.getInt("away_team_id");
                Timestamp matchDate = resultSet.getTimestamp("match_date");
                int homeTeamGoals = resultSet.getInt("home_team_goals");
                int awayTeamGoals = resultSet.getInt("away_team_goals");
                int winnerTeamId = resultSet.getInt("winner_team_id");

                String winner = (winnerTeamId == 0) ? "Draw" : (winnerTeamId == team1Id) ? "Team 1" : "Team 2";

                System.out.println("Match ID: " + id);
                System.out.println("Teams: Team " + team1Id + " vs Team " + team2Id);
                System.out.println("Score: " + homeTeamGoals + " - " + awayTeamGoals);
                System.out.println("Winner: " + winner);
                System.out.println("Match Date: " + matchDate);
                System.out.println();
            }
        }
    }

    private void displayMatchInfo(int matchId) throws SQLException {
        String query = "SELECT * From matches WHERE match_id = " + matchId;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("match_id");
                int team1Id = resultSet.getInt("home_team_id");
                int team2Id = resultSet.getInt("away_team_id");
                Timestamp matchDate = resultSet.getTimestamp("match_date");
                int homeTeamGoals = resultSet.getInt("home_team_goals");
                int awayTeamGoals = resultSet.getInt("away_team_goals");
                int winnerTeamId = resultSet.getInt("winner_team_id");

                String winner = (winnerTeamId == 0) ? "Draw" : (winnerTeamId == team1Id) ? "Team 1" : "Team 2";

                System.out.println("Match ID: " + id);
                System.out.println("Teams: Team " + team1Id + " vs Team " + team2Id);
                System.out.println("Score: " + homeTeamGoals + " - " + awayTeamGoals);
                System.out.println("Winner: " + winner);
                System.out.println("Match Date: " + matchDate);
                System.out.println();
            }
        }
    }
}
