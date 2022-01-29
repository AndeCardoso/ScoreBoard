package services;

import entities.Game;
import entities.Team;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;


public class FileMananger {
    static ArrayList<Game> DataOfFile;

    final static String GAME_RESULTS = "src/resources/input/game_results.csv";

    public static void readAllFile() {
        try {
            FileReader file = new FileReader(GAME_RESULTS);
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();
            getLine(line);
            do{
                getLine(line);
                line = reader.readLine();
            } while(line != null);

        } catch (FileNotFoundException ex){
            System.out.println("The game_statistics.txt file will be created on your game folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getLine(String lineOfFile) {
        if(!Objects.equals(lineOfFile, "")){
            String[] splittedData = lineOfFile.split(";");


            for(int i = 0 ; i< splittedData.length ; i++){
                System.out.println(splittedData[i]);
            }
//            DataOfFile.add(new Game(
//                    splittedData[0],
//                    splittedData[1],
//                    Integer.parseInt(splittedData[2]),
//                    Integer.parseInt(splittedData[3]),
//                    splittedData[4]
//                )
//            );

        }
    }

}
