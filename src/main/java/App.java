
import services.FileManager;

public class App {
    public static void main(String[] args) {
        FileManager file = new FileManager();
        System.out.println(file.readAllFile());
    }
}
