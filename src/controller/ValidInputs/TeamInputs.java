package controller.ValidInputs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TeamInputs {

    public static Set<String> lakersSet = new HashSet<>(Arrays.asList("lakers", "Lakers", "l", "L",
            "laker", "Laker", "LAKERS"));
    public static Set<String> warriorsSet = new HashSet<>(Arrays.asList("warriors", "Warriors", "w", "W",
            "warrior", "Warrior", "WARRIORS"));
    public static Set<String> sixersSet = new HashSet<>(Arrays.asList("sixers", "Sixers", "s", "S",
            "six", "Six", "76ers", "SIXERS"));
    public static Set<String> cetlicsSet = new HashSet<>(Arrays.asList("celtics", "Celtics", "c", "C",
            "celtic", "Celtic", "CELTICS"));
}
