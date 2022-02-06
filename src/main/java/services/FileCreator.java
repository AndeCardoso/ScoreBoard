package services;

import entities.Game;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCreator {

    private static final String OUTPUT_FILE_PATH = "src/resources/output/";
    private static final String TEAM_FILE_HEADER = "File containing the matches for ";
    private static final String HEADER_FINAL_FILE = "Team;Victories;Ties;Losses;Points";

    public static void createTeamFile(String teamName) {
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFinalFile()  {
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

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
