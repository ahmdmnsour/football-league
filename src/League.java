import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class League {
    private int leagueId;
    private String leagueName;
    private List<Integer> teamsIds;

    public League() {
    }

    public League(int leagueId, String leagueName) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.teamsIds = new ArrayList<>();
    }

    public int getLeagueId() {
        return leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    private int getRandomTeam() {
        Random random = new Random();
        return teamsIds.get(random.nextInt(teamsIds.size()));
    }
}
