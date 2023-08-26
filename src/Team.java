import java.util.ArrayList;
import java.util.List;

public class Team {
    private int teamId;
    private String teamName;
    private String coachName;
    private List<Player> players;

    public Team() {
        players = new ArrayList<>();
    }

    public Team(String teamName) {
        this.teamName = teamName;
        players = new ArrayList<>();
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Team(String teamName, String coachName, List<Player> players) {
        this.teamName = teamName;
        this.coachName = coachName;
        this.players = players;

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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        if (players.contains(player))
            System.out.println(player.getName() + " already plays in " + teamName);
        else
            this.players.add(player);
    }

    public void removePlayer(Player player) {
        if (!players.contains(player))
            System.out.println(player.getName() + " is not in " + teamName);
        else
            this.players.remove(player);
    }
}
