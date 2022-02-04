import entities.Team;
import services.CsvFileManager;
import services.FileManager;

import java.util.Collections;

public class App {
    public static void main(String[] args) {

//        CsvFileManager.readFile();
//        CsvFileManager.convertCsvToList();
        System.out.println(FileManager.GameList);
        Team team = new Team("Grêmio");
        team.getData();
    }
}
