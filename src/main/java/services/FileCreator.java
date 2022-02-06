package services;

import entities.Team;

import java.io.*;
import java.util.List;
import java.util.Map;

public class FileCreator {

    static final String OUTPUT_FILE_PATH = "src/resources/output/";
    static final String TEAM_FILE_HEADER = "File containing the matches for ";
    static final String CLASSIFICATION_FILE_HEADER = "time_1(mandante);time2(visitante);placar_time_1;placar_time_2;data";

    public static void createClassification() {
        try {
            String PATH = OUTPUT_FILE_PATH + "final_classification" + ".csv";
            File finalClassificationFile = new File(PATH);
            FileWriter myWriter = new FileWriter(PATH);
            if (finalClassificationFile.createNewFile()) {
                List<String> list = FileManager.getChampionshipList();
                myWriter.write(CLASSIFICATION_FILE_HEADER);
                list.forEach(line -> {
                    try {
                        myWriter.write(line);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                myWriter.close();
                System.out.println("File created: Final Classification");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("A error occurred when creating the file.");
            e.printStackTrace();
        }
    }

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
