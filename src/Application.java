import controller.BasketballSimulator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- Programmed by Christopher Banas --"); //TODO Make this look better
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
        System.out.println("1) Load league from file (not implemented yet)");
        System.out.println("2) Auto generate league");
        String input = "";
        Set<String> validInputSet = new HashSet<>(Arrays.asList("1", "2")); //set in case more modes are added
        while(!validInputSet.contains(input)){
            System.out.print("> ");
            input = scanner.nextLine();
            if(!validInputSet.contains(input)){
                System.out.println("Error: Enter displayed number as input");
            }
        }
        if ("1".equals(input)) {
            System.out.println("Load league from file selected");
        } else if ("2".equals(input)) {
            System.out.println("Auto generate league selected");
        }
        BasketballSimulator simulator = new BasketballSimulator(input);
    }
}
