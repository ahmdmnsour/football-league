import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team {
    private String teamName;
    private String coachName;
    private List<String> playersNames;

    public Team() {
        playersNames = new ArrayList<>();
    }

    public Team(String teamName) {
        this.teamName = teamName;
        playersNames = new ArrayList<>();
    }

    public Team(String teamName, String coachName, List<String> playersNames) {
        this.teamName = teamName;
        this.coachName = coachName;
        this.playersNames = playersNames;

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

    public List<String> getPlayersNames() {
        return playersNames;
    }

    public void setPlayersNames(List<String> playersNames) {
        this.playersNames = playersNames;
    }

    public void addPlayer(String playerName) {
        if (playersNames.contains(playerName))
            System.out.println(playerName + " already plays in " + teamName);
        else
            this.playersNames.add(playerName);
    }

    public void removePlayer(String playerName) {
        if (!playersNames.contains(playerName))
            System.out.println(playerName + " is not in " + teamName);
        else
            this.playersNames.remove(playerName);
    }


}
