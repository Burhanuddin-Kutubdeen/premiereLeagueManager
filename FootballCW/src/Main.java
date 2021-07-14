

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();


    public static void main(String[] args) throws IOException {
        premierLeagueManager.loadFile("textFile.txt", "textFile2.txt");
        Main m = new Main();
        while (true) {
            System.out.println("'A' to add team: " + '\n' +
                    "'D' to delete team: " + '\n' +
                    "'I' to show statistics of team: " + '\n' +
                    "'T' to show table of team: " + '\n' +
                    "'M' to add a match: " + '\n' +
                    "'S' to save: " + '\n' +
                    "'G' for information in GUI: " + '\n' +
                    "'Q' to quit menu: ");

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your Choice!");
            String userChoice = scan.next();

            switch (userChoice.toUpperCase()) {
                case "A":
                    premierLeagueManager.addClub();
                    break;
                case "D":
                    m.deleteClub();
                    break;
                case "I":
                    m.statistics();
                    break;
                case "T":
                    premierLeagueManager.displayLeagueTable();
                    break;
                case "M":
                    premierLeagueManager.addMatch();
                    break;
                case "S":
                    premierLeagueManager.saveFile("textFile.txt", "textFile2.txt");
                    System.exit(0);//save and exit
                case "G":
                    GUI.plm = premierLeagueManager;
                    GUI.launch(GUI.class);
                    break;

                default:
                    System.out.println("Choice invalid, Please enter again...");
            }
        }
    }


    private void deleteClub() {
        System.out.println("Please enter the name of the club you want to remove:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        premierLeagueManager.deleteClub(name);
    }
    private void statistics() {
        System.out.println("Please enter the name of the club :");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        premierLeagueManager.displayStats(name);
    }



}



