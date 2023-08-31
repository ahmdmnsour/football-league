import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Match {
    private int matchId;
    private int homeTeamId;
    private int awayTeamId;
    private Timestamp matchDate;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private int winnerId;

    public Match() { }

    public Match(int matchId, int homeTeamId, int awayTeamId, Timestamp matchDate, int homeTeamGoals, int awayTeamGoals, int winnerId) {
        this.matchId = matchId;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.matchDate = matchDate;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
        this.winnerId = winnerId;
    }

    public Match(int homeTeamId, int awayTeamId, Timestamp matchDate) {
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.matchDate = matchDate;

        simulateMatch();
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public int getWinnerId() {
        return winnerId;
    }

    private void simulateMatch() {
        Random random = new Random();
        homeTeamGoals = random.nextInt(8);
        awayTeamGoals = random.nextInt(8);

        if (homeTeamGoals > awayTeamGoals) {
            winnerId = homeTeamId;
        } else if (homeTeamGoals < awayTeamGoals) {
            winnerId = awayTeamId;
        }
    }
}
