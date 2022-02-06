package services;

import entities.Team;

import java.io.*;
import java.util.Map;

public class FileCreator {

    static final String OUTPUT_FILE_PATH = "src/resources/output/";
    static final String TEAM_FILE_HEADER = "File containing the matches for ";

    public static void createFile(String teamName) {
        try {
            File teamFile = new File(OUTPUT_FILE_PATH + teamName + ".txt");
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

    public static void writeInFiles(String teamName) {
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
}
