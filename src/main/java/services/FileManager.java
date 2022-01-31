package services;

import entities.Game;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileManager {
    private ArrayList<Game> GamesOfFile = new ArrayList<>();

    final String GAME_RESULTS = "src/resources/input/game_results.csv";

    public ArrayList<Game> readAllLines() {
        try {
            FileReader file = new FileReader(GAME_RESULTS);
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();
            do{
                GamesOfFile.add(getLine(line));
                line = reader.readLine();
            } while(line != null);
            reader.close();
            return GamesOfFile;

        } catch (FileNotFoundException ex){
            System.out.println("The required file will be created on your game folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Game getLine(String lineOfFile) {
        try {
            if(!Objects.equals(lineOfFile, "")){
                String[] splittedData = lineOfFile.split(";");
                SimpleDateFormat dateParser = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                Game gameLine = new Game(
                        (splittedData[0]),
                        (Integer.parseInt(splittedData[2])),
                        (splittedData[1]),
                        (Integer.parseInt(splittedData[3])),
                        (dateParser.parse(splittedData[4]))
                );
                return gameLine;

            } else {
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
