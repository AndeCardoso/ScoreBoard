package services;

import entities.Game;
import entities.Team;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileManager {

    public static List<Game> GameList;
    public static Set<Game> GamesOfFile = new HashSet<>();

    static final String FILE_NAME = "src/resources/input/game_results.csv";

    public static ArrayList<Game> getByTeamName(String name) {
        readAllLines();
        ArrayList<Game> listGamesByTeam = new ArrayList<>();
        for (Game game : GameList) {
            if(game.getHomeTeam().equalsIgnoreCase(name) || game.getAwayTeam().equalsIgnoreCase(name)){
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
            GameList = new ArrayList<>(GamesOfFile);
            GameList.sort(FileManager::compareDate);
            System.out.println(GameList);
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

    private static int compareDate(Game cur, Game nex) {
        if (cur.getDate() == null || nex.getDate() == null) {
            return 0;
        }
        return cur.getDate().compareTo(nex.getDate());
    }

    public void writeInFiles() {
        
    }

    public static void agrupamentoPorIteracao() {
        Map<String, Team> agrupamento = new HashMap<>();
        for (Game game : GameList) {
            String name = game.getHomeTeam();

            Team team = agrupamento.getOrDefault(name, new Team(name));
            team.getTeamGames().add(game);
            agrupamento.put(name, team);

            String name2 = game.getAwayTeam();

            Team team2 = agrupamento.getOrDefault(name2, new Team(name2));
            team2.getTeamGames().add(game);
            agrupamento.put(name2, team2);
        }
        System.out.println(agrupamento);
    }
}
