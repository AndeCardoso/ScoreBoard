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

    private static int compareDate(Game cur, Game nex) {
        if (cur.getDate() == null || nex.getDate() == null) {
            return 0;
        }
        return cur.getDate().compareTo(nex.getDate());
    }

    public void writeInFiles() {
        
    }

    public static Map<String, Team> createTeams() {
        Map<String, Team> teamsMap = new HashMap<>();
        for (Game game : GameList) {
            String name = game.getHomeTeam();

            Team team = teamsMap.getOrDefault(name, new Team(name));
            team.getTeamGames().add(game);
            teamsMap.put(name, team);

            String name2 = game.getAwayTeam();

            Team team2 = teamsMap.getOrDefault(name2, new Team(name2));
            team2.getTeamGames().add(game);
            teamsMap.put(name2, team2);
        }

        for (Team team : teamsMap.values()){
            team.getData();
        }
        System.out.println(teamsMap);
        return teamsMap;
    }

    public static List<String> getChampionshipList(){
        Map<String, Team> teamsMap = FileManager.createTeams();
        List<String> toPrint = new ArrayList<>();
        teamsMap.values().stream().sorted(Comparator.comparing(Team::getPoints, Comparator.reverseOrder())
                        .thenComparing(Team::getVictory, Comparator.reverseOrder())
                        .thenComparing(Team::getGoalsScore, Comparator.reverseOrder())
                        .thenComparing(Team::getName))
                .forEach(value -> {
                    toPrint.add(value.getName().concat(";")
                            .concat(String.valueOf(value.getVictory()+";")
                            .concat(String.valueOf(value.getTies()+";"))
                            .concat(String.valueOf(value.getDefeat()+";"))
                            .concat(String.valueOf(value.getPoints()+";"))));
                });
        toPrint.forEach(System.out::println);
        return toPrint;
    }
}
