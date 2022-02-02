import entities.Team;
import services.CsvFileManager;

public class App {
    public static void main(String[] args) {
//        FileManager file = new FileManager();
//        ArrayList<Game> list = file.readAllLines();
//        Collections.sort(list, (cur, nex) -> {
//            if (cur.getDateTime() == null || nex.getDateTime() == null) {
//                return 0;
//            }
//            return cur.getDateTime().compareTo(nex.getDateTime());
//        });
//        System.out.println("after" + list);

        CsvFileManager.readFile();
        CsvFileManager.convertCsvToList();

//        Team team1 = new Team("Santos");
//        team1.getData();
    }
}
