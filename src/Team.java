import java.util.ArrayList;
import java.util.List;

public class Team {
    private int teamId;
    private String teamName;
    private String coachName;
    private List<Integer> playersIds;

    public Team() {
        playersIds = new ArrayList<>();
    }

    public Team(int teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
        playersIds = new ArrayList<>();
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Team(String teamName, String coachName, List<Integer> playersIds) {
        this.teamName = teamName;
        this.coachName = coachName;
        this.playersIds = playersIds;

    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public List<Integer> getPlayersIds() {
        return playersIds;
    }

    public void setPlayers(List<Integer> playersIds) {
        this.playersIds = playersIds;
    }
}
