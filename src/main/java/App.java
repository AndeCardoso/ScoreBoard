import entities.Team;
import services.FileCreator;
import services.FileManager;

import java.util.Map;

public class App {
    public static void main(String[] args) {

//        CsvFileManager.readFile();
//        CsvFileManager.convertCsvToList();
        FileManager.readAllLines();
        Map<String, Team> teamsMap;
        teamsMap = FileManager.createTeams();
//        Team team = new Team("Grêmio");
//        team.getData();

        for (Team team : teamsMap.values()) {
            FileCreator.createFile(team.getName());
            FileCreator.writeInFiles(team.getName());
        }
    }
}
