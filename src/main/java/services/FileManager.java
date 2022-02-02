package services;

import entities.Game;

import java.io.*;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Objects;
import java.text.SimpleDateFormat;
import java.util.Set;

public class FileManager {
    private static final Set<Game> GamesOfFile = new HashSet<>();

    static final String GAME_RESULTS = "src/resources/input/game_results.csv";

    public static Set<Game> getByTeamName(String name) {
        Set<Game> gamesByTeam = (Set<Game>) GamesOfFile.stream()
                .filter(games -> games.getHomeTeam().equals(name) || games.getAwayTeam().equals(name));
        return gamesByTeam;
    }

    public static Set<Game> readAllLines() {
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

    private static Game getLine(String lineOfFile) {
        try {
            if(!Objects.equals(lineOfFile, "")){
                String[] splitData = lineOfFile.split(";");
                SimpleDateFormat dateParser = new SimpleDateFormat("yy-MM-dd");
                return new Game(
                        (splitData[0]),
                        (Integer.parseInt(splitData[2])),
                        (splitData[1]),
                        (Integer.parseInt(splitData[3])),
                        (dateParser.parse(splitData[4]))
                );

            } else {
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeInFiles() {
        
    }
}
