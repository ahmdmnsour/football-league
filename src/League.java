import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class League {
    private String leagueName;
    private List<Team> teams;

    public League() {
    }

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }

    public League(String leagueName, List<Team> teams) {
        this.leagueName = leagueName;
        this.teams = teams;
    }

    public void addTeam(Team team) {
        if (!teams.isEmpty() && teams.contains(team))
            System.out.println(team + " already in " + leagueName);
        else
            this.teams.add(team);
    }

    public void removeTeam(Team team) {
        if (!teams.contains(team))
            System.out.println(team + " is not in " + leagueName);
        else
            this.teams.remove(team);
    }

    private Team getRandomTeam() {
        Random random = new Random();
        return teams.get(random.nextInt(teams.size()));
    }

    public Match simulateRandomMatch() {
        Team homeTeam = getRandomTeam();
        Team awayTeam = getRandomTeam();
        while (homeTeam == awayTeam) {
            awayTeam = getRandomTeam();
        }
        return new Match(homeTeam, awayTeam, new Date());
    }
}
