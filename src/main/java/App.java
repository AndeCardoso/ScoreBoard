import entities.Team;
import services.CsvFileManager;

public class App {
    public static void main(String[] args) {

//        CsvFileManager.readFile();
//        CsvFileManager.convertCsvToList();

        Team team1 = new Team("Santos");
        team1.getData();
    }
}
