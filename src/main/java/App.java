import entities.Team;
import services.CsvFileManager;
import services.FileManager;

import java.util.Collections;

public class App {
    public static void main(String[] args) {

//        CsvFileManager.readFile();
//        CsvFileManager.convertCsvToList();
        FileManager.readAllLines();
        ;
        System.out.println(FileManager.GamesOfFile);
        Team team = new Team("Grêmio");
        team.getData();
    }
}
