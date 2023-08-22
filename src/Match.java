import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private Date matchDate;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private Team winner;
    private List<String> goalScorers;

    public Match() { }

    public Match(Team homeTeam, Team awayTeam, Date matchDate) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDate = matchDate;
        this.goalScorers = new ArrayList<>();

        simulateMatch();
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public List<String> getGoalScorers() {
        return goalScorers;
    }

    public void setGoalScorers(List<String> goalScorers) {
        this.goalScorers = goalScorers;
    }

    public String getFullTimeScore() {
        return homeTeamGoals + " - " + awayTeamGoals;
    }

    private void simulateMatch() {
        Random random = new Random();
        homeTeamGoals = random.nextInt(5);
        awayTeamGoals = random.nextInt(5);

        if (homeTeamGoals > awayTeamGoals) {
            winner = homeTeam;
        } else if (homeTeamGoals < awayTeamGoals) {
            winner = awayTeam;
        } else {
            winner = null;
        }

        for (int i = 0; i < homeTeamGoals; i++) {
            String scorer = homeTeam.getPlayersNames().get(random.nextInt(homeTeam.getPlayersNames().size()));
            goalScorers.add(scorer);
        }

        for (int i = 0; i < awayTeamGoals; i++) {
            String scorer = awayTeam.getPlayersNames().get(random.nextInt(awayTeam.getPlayersNames().size()));
            goalScorers.add(scorer);
        }
    }
}
