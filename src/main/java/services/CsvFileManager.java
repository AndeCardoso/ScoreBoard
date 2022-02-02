package services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CsvFileManager {

  public static final String FILE_NAME = "src/resources/input/game_results.csv";

  public static void readFile() {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME, UTF_8))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void convertCsvToList() {
    try {
      List<String> allLines = Files.readAllLines(Paths.get(FILE_NAME));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
