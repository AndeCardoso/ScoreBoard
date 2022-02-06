package utils;

import entities.Team;
import services.FileCreator;
import services.FileManager;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Printer {

    public static void Menu() {
        FileManager.readAllLines();
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println(
            "                       _,aaadP\"\"\"\"\"\"Ybaaaa,,_\n" +
            "                   ,adP,__,,,aaaadP\"\"\"\"\"Y888888a,_\n" +
            "                ,a8888888P\"''             \"Y8888888b,\n" +
            "             _a888888888\"                   `Y88888888b,\n" +
            "           ,d888888888P'                       \"888888888b,\n" +
            "         ,88888888P\"Y8,                       ,P'   `\"\"Y888b,\n" +
            "       ,d8888P\"'     \"Ya,                    ,P'         `Ya`b,\n" +
            "      ,P88\"'           `Ya,                 ,P'            `b`Yi\n" +
            "     d\",P                `\"Y,              ,P'              `Y \"i\n" +
            "   ,P' P'                   \"888888888888888b                `b \"i\n" +
            "  ,P' d'                    d8888888888888888b                `b `b\n" +
            "  d' d'                    ,888888888888888888b                I, Y,\n" +
            " ,f ,f                    ,88888888888888888888b               `b, b\n" +
            " d' d'                    d888888888888888888888b              ,888,I\n" +
            ",P  8                    ,88888888888888888888888b,_          ,d88888\n" +
            "d'  8,                   d8888888888888888888888P'`\"Ya,_     ,d888888\n" +
            "8  d88b,             ,adP\"\"Y888888888888888888P'      `\"\"Ya, d8888888\n" +
            "8 ,88888b,       ,adP\"'     `\"Y8888888888888\"'             `\"88888888\n" +
            "Y,88888888b, ,adP\"'             \"\"Y888888P\"                  88888888'\n" +
            "`888888888888P'                     \"\"YP\"                    88888888\n" +
            " I88888888888                          8                     888888I\n" +
            " `Y8888888888                          8                     888888'\n" +
            "  `Y888888888                          8                     88888I\n" +
            "   `Y88888888                          8                     8P\"8'\n" +
            "    `Y8888888,                         8                   ,d',d'\n" +
            "     `b\"\"\"\"Y8b                         8                 ,d\" ,d'\n" +
            "       \"b,   \"Y,                       8               ,P\" ,d\"\n" +
            "         \"b,   \"Ya,_                 ,d88ba,,___   _,aP\" ,P\"\n" +
            "           \"Ya_   \"\"Ya,_       _,,ad88888888888888P\"' _,d\"\n" +
            "             `\"Ya_    \"\"Yaaad88888888888888888888P _,d\"'\n" +
            "                 `\"Ya,_     \"Y888888888888888888P\",d\"'\n" +
            "                    `\"\"Ya,__`Y888888888888888P\"\"\"\n" +
            "                         ``\"\"\"\"\"\"\"\"\"\"\"\"\"''\n" +
            "=============================================================================\n" +
            "=============================================================================\n" +
            "====================  BIG BRAZILIAN SOCCER SCOREBOARD  ======================\n" +
            "============================== by squad nº 12 ===============================\n" +
            "=============================================================================\n" +
            " - Press 1 to generate/update ScoreBoard ordered by points:\n" +
            " - Press 2 to generate/update all teams files:\n" +
            " - Press 3 to choice a team for list information:\n" +
            " - Press exit to close the program.\n"
        );
        input = scan.next();
        switch (input) {
            case "1":
                optionOne();
                break;
            case "2":
                optionTwo();
                break;
            case "3":
                optionThree();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Wrong value! Press any key to return to the menu...");
                String any = scan.next();
                if(!Objects.equals(any, "")){
                    Menu();
                }
                break;
        }
    }

    private static void optionOne() {
        FileCreator.createFinalFile();

        Scanner scan = new Scanner(System.in);
        System.out.println(
                "File with classification was generated!\n" +
                "Press any key to return to the menu..."
        );
        String any = scan.next();
        if(!Objects.equals(any, "")){
            Menu();
        }
    }

    private static void optionTwo() {
        Map<String, Team> teamsMap = FileManager.createTeams();
        for (Team team : teamsMap.values()) {
            FileCreator.createTeamFile(team.getName());
        }

        Scanner scan = new Scanner(System.in);
        System.out.println(
                "All files with teams information was generated!\n" +
                "Press any key to return to the menu..."
        );
        String any = scan.next();
        if(!Objects.equals(any, "")){
            Menu();
        }
    }

    private static void optionThree() {
        Scanner scan = new Scanner(System.in);
        String name = "";
        while (!Objects.equals(name, "exit")) {
            System.out.println(
                    " - Insert the name of team you want know about:\n" +
                    "*insert exit to return to the menu*"
            );
            name = scan.nextLine();
            if(!Objects.equals(name, "exit")) {
                Team.printInfos(name);
            } else {
                Menu();
            }
        }
    }
}
