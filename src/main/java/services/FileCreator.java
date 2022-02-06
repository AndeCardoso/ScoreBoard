package services;

import java.io.*;

public class FileCreator {

    static final String OUTPUT_FILE_PATH = "src/resources/output/";

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
            myWriter.write("Write content here:");
            myWriter.close();
            System.out.println("Successfully wrote to the file: " + OUTPUT_FILE_PATH + teamName + ".txt.");
        } catch (IOException e) {
            System.out.println("A writing error occurred.");
            e.printStackTrace();
        }
    }
}
