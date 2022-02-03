package services;

import entities.Game;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.text.SimpleDateFormat;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileManager {

    public static ArrayList<Game> GamesOfFile = new ArrayList<>();

    static final String FILE_NAME = "src/resources/input/game_results.csv";

    public static ArrayList<Game> getByTeamName(String name) {
        readAllLines();
        ArrayList<Game> listGamesByTeam = new ArrayList<>();
        for (Game game : GamesOfFile) {
            if(Objects.equals(game.getHomeTeam(), name) || Objects.equals(game.getAwayTeam(), name)){
                listGamesByTeam.add(game);
            }
        }
        return listGamesByTeam;
    }

    public static void readAllLines() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME, UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                GamesOfFile.add(getLine(line));
            }
            GamesOfFile.sort((cur, nex) -> {
                if (cur.getDate() == null || nex.getDate() == null) {
                    return 0;
                }
                return cur.getDate().compareTo(nex.getDate());
            });
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Game getLine(String lineOfFile) {
        try {
            if(!Objects.equals(lineOfFile, "")){
                String[] splitData = lineOfFile.split(",");
                SimpleDateFormat dateParser = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
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
