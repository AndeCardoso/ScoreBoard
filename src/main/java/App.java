import entities.Team;
import services.FileCreator;
import services.FileManager;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        FileManager.readAllLines();
        Map<String, Team> teamsMap = FileManager.createTeams();
        for (Team team : teamsMap.values()) {
            FileCreator.createTeamFile(team.getName());
            FileCreator.writeTeamFile(team.getName());
        }
        FileManager.getChampionshipList();
        FileCreator.createFinalFile();
    }
}
