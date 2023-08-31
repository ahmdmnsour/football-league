import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    String jdbcUrl = "jdbc:postgresql://localhost:5432/football";
    String username = "postgres";
    String password = "admin";
    static Connection connection;

    public DB() throws SQLException {
        connection = DriverManager.getConnection(jdbcUrl, username, password);
    }

    public ArrayList<League> getLeagues() throws SQLException {
        ArrayList<League> leagues = new ArrayList<>();
        String query = "SELECT league_id, league_name FROM leagues";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next())
                leagues.add(new League(resultSet.getInt(1), resultSet.getString(2)));
        }
        return leagues;
    }

    public ArrayList<Team> getTeamsFromLeague(int leagueId) throws SQLException {
        ArrayList<Team> teams = new ArrayList<>();
        String query = "SELECT * FROM teams t " +
                "INNER JOIN team_league tl ON t.team_id = tl.team_id " +
                "WHERE tl.league_id = " + leagueId;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                teams.add(new Team(resultSet.getInt(1), resultSet.getString(2)));
            }
        }
        return teams;
    }

    public ArrayList<Integer> getTeamsIdsFromLeague(int leagueId) throws SQLException {
        ArrayList<Integer> teams = new ArrayList<>();
        String query = "SELECT * FROM teams t " +
                "INNER JOIN team_league tl ON t.team_id = tl.team_id " +
                "WHERE tl.league_id = " + leagueId;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                teams.add(resultSet.getInt(1));
            }
        }
        return teams;
    }

    public ArrayList<Team> getAllTeams() throws SQLException {
        ArrayList<Team> teams = new ArrayList<>();
        String query = "SELECT * FROM teams";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                teams.add(new Team(resultSet.getInt(1), resultSet.getString(2)));
            }
        }
        return teams;
    }

    public ArrayList<Player> getPlayersFromTeam(int teamId) throws SQLException {
        ArrayList<Player> players = new ArrayList<>();
        String query = "SELECT name FROM players WHERE team_id = " + teamId;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                players.add(new Player(resultSet.getInt(1), resultSet.getString(2)));
            }
        }
        return players;
    }

    public ArrayList<Match> getMatches() throws SQLException {
        ArrayList<Match> matches = new ArrayList<>();
        String query = "SELECT * FROM matches";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("match_id");
                int homeTeamId = resultSet.getInt("home_team_id");
                int awayTeamId = resultSet.getInt("away_team_id");
                Timestamp matchDate = resultSet.getTimestamp("match_date");
                int homeTeamGoals = resultSet.getInt("home_team_goals");
                int awayTeamGoals = resultSet.getInt("away_team_goals");
                int winnerTeamId = resultSet.getInt("winner_team_id");
                Match match = new Match(id, homeTeamId, awayTeamId, matchDate, homeTeamGoals, awayTeamGoals, winnerTeamId);
                matches.add(match);
            }
        }
        return matches;
    }

    public String getTeamName(int teamId) throws SQLException {
        String query = "SELECT * FROM teams WHERE team_id = " + teamId;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next())
                return resultSet.getString(2);
        }
        return null;
    }

    public void insertNewMatch(Match match) throws SQLException {
        String query = "INSERT INTO matches (home_team_id, away_team_id, match_date, home_team_goals, away_team_goals, winner_team_id)\n" +
                "VALUES" + "("
                + match.getHomeTeamId() + ", "
                + match.getAwayTeamId() + ", "
                + "'" + match.getMatchDate() + "'" + ", "
                + match.getHomeTeamGoals() + ", "
                + match.getAwayTeamGoals() + ", "
                + match.getWinnerId() + ");";
        Statement statement = connection.createStatement();
        int insertion = statement.executeUpdate(query);
    }
}
