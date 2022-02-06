package services;

import entities.Game;
import entities.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileCreator {

    private static final String OUTPUT_FILE_PATH = "src/resources/output/";
    private static final String TEAM_FILE_HEADER = "File containing the matches for ";
    private static final String HEADER_FINAL_FILE = "Team;Victories;Ties;Losses;Points";

    public static void createAllFiles() {
        FileManager.readAllLines();
        FileManager.getChampionshipList();
        FileCreator.createFinalFile();
        Map<String, Team> teamsMap = FileManager.createTeams();
        for (Team team : teamsMap.values()) {
            FileCreator.createTeamFile(team.getName());
        }
        for (Team team : teamsMap.values()) {
            Team.printInfos(team);
        }
    }

    private static void createTeamFile(String teamName) {
        try {
            List<Game> list = new ArrayList<>(FileManager.createTeams().get(teamName).getTeamGames());
            FileWriter myWriter = new FileWriter(OUTPUT_FILE_PATH + teamName + ".txt");
            myWriter.write(TEAM_FILE_HEADER + teamName + ".\n\n");
            list.forEach(line -> {
                try {
                    myWriter.write(String.valueOf(line));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            myWriter.close();
            System.out.println("Successfully wrote to the file: " + OUTPUT_FILE_PATH + teamName + ".txt.");

        } catch (IOException e) {
            System.out.println("A error occurred when creating the file.");
            e.printStackTrace();
        }
    }

    private static void createFinalFile()  {
        try {
            List<String> list = FileManager.getChampionshipList();
            FileWriter myWriter = new FileWriter(OUTPUT_FILE_PATH + "FinalFile.csv");
            myWriter.write(HEADER_FINAL_FILE);
            myWriter.write("\n");
            list.forEach(line -> {
                try {
                    myWriter.write(line);
                    myWriter.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            myWriter.close();
            System.out.println("Successfully wrote to the file: " + OUTPUT_FILE_PATH + "FinalFile.csv");
        }catch (IOException e) {
            System.out.println("A writing error occurred.");
            e.printStackTrace();
        }
    }
}
