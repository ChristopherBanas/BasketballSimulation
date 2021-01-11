import controller.BasketballSimulator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                -- Programmed by Christopher Banas --
                ------- BASKETBALL SIMULATOR --------
                
                League restrictions as of version 1.0:
                - 4 team league
                - 9 players per team
                
                -------------------------------------
                
                Play options:
                
                1) Load league from file
                2) Auto generate league
                """);
        String input = "";
        Set<String> validInputSet = new HashSet<>(Arrays.asList("1", "2")); //set in case more modes are added
        while(!validInputSet.contains(input)){
            System.out.print("> ");
            input = scanner.nextLine();
            if(!validInputSet.contains(input)){
                System.out.println("Error: Enter displayed number as input");
            }
        }
        switch (input) {
            case "1" -> System.out.println("Load league from file selected");
            case "2" -> System.out.println("Auto generate league selected");
        }
        BasketballSimulator simulator = new BasketballSimulator(input);
    }
}
