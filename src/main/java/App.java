import services.FileManager;

public class App {
    public static void main(String[] args) {

//        CsvFileManager.readFile();
//        CsvFileManager.convertCsvToList();
        FileManager.readAllLines();
        FileManager.getChampionshipList();
//        Team team = new Team("Grêmio");
//        team.getData();

    }
}
