import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Match {
    private int matchId;
    private Team homeTeam;
    private Team awayTeam;
    private Date matchDate;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private Team winner;
    private List<Player> goalScorers;

    public Match() { }

    public Match(Team homeTeam, Team awayTeam, Date matchDate) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDate = matchDate;
        this.goalScorers = new ArrayList<>();

        simulateMatch();
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
            Player scorer = homeTeam.getPlayers().get(random.nextInt(homeTeam.getPlayers().size()));
            goalScorers.add(scorer);
        }

        for (int i = 0; i < awayTeamGoals; i++) {
            Player scorer = awayTeam.getPlayers().get(random.nextInt(awayTeam.getPlayers().size()));
            goalScorers.add(scorer);
        }
    }
}
