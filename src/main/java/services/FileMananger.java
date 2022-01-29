package services;

import entities.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FileMananger {
    static ArrayList<Team> DataOfFile;

    final static String GAME_RESULTS = "src/resources/input/game_results.csv";

    public static void readFile() {
        try {
            FileReader file = new FileReader(GAME_RESULTS);
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();

            while(line != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException ex){
            System.out.println("The game_statistics.txt file will be created on your game folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getLine(String lineOfFile) {
        if(!Objects.equals(lineOfFile, "")){
            String[] splittedData = lineOfFile.split(";");
            DataOfFile.add(new Team)

        }
    }

}
