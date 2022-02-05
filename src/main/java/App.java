import entities.Team;
import services.CsvFileManager;
import services.FileManager;

import java.util.Collections;

public class App {
    public static void main(String[] args) {

//        CsvFileManager.readFile();
//        CsvFileManager.convertCsvToList();
        FileManager.readAllLines();
        FileManager.agrupamentoPorIteracao();
//        Team team = new Team("Grêmio");
//        team.getData();

    }
}
