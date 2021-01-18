import controller.BasketballSimulator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * File that user should run, will prompt and pass execution onto BasketballSimulator
 */
public class Application {

    /**
     * Prompts the user to input their play option
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- Programmed by Christopher Banas --");
        System.out.println("------- BASKETBALL SIMULATOR --------");
        System.out.println(" ");
        System.out.println("League restrictions as of version 1.0:");
        System.out.println("- 4 team league");
        System.out.println("- 9 players per team");
        System.out.println(" ");
        System.out.println("-------------------------------------");
        System.out.println(" ");
        System.out.println("Play options: ");
        System.out.println(" ");
        System.out.println("1) Load league from text file");
        System.out.println("2) Auto generate league");
        String input = "";
        Set<String> validInputSet = new HashSet<>(Arrays.asList("1", "2")); //set in case more modes are added
        while(!validInputSet.contains(input)){
            System.out.print("> ");
            input = scanner.nextLine();
            if(!validInputSet.contains(input)){
                System.out.println("Error: Enter displayed number as input");
                System.out.println("");
            }
        }
        new BasketballSimulator(input);
    }
}
