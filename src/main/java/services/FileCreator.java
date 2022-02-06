package services;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileCreator {

    private static final String OUTPUT_FILE_PATH = "src/resources/output/";
    private static final String TEAM_FILE_HEADER = "File containing the matches for ";
    private static final String HEADER_FINAL_FILE = "Team;Victories;Ties;Losses;Points";

    public static void createTeamFile(String teamName) {
        try {
            File teamFile = new File(OUTPUT_FILE_PATH + teamName + ".txt");
            FileWriter myWriter = new FileWriter(OUTPUT_FILE_PATH + teamName + ".txt");
            if (teamFile.createNewFile()) {
                System.out.println("File created: " + teamFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("A error occurred when creating the file.");
            e.printStackTrace();
        }
    }

    public static void writeTeamFile(String teamName) {
        try {
            FileWriter myWriter = new FileWriter(OUTPUT_FILE_PATH + teamName + ".txt");
            myWriter.write(TEAM_FILE_HEADER + teamName + ".\n\n");
            myWriter.write(String.valueOf(FileManager.createTeams().get(teamName).getTeamGames()));
            myWriter.close();
            System.out.println("Successfully wrote to the file: " + OUTPUT_FILE_PATH + teamName + ".txt.");
        } catch (IOException e) {
            System.out.println("A writing error occurred.");
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
            System.out.println("Successfully wrote to the file: " + OUTPUT_FILE_PATH + "FinalFile.csv");
        }catch (IOException e) {
            System.out.println("A writing error occurred.");
            e.printStackTrace();
        }
    }
}
