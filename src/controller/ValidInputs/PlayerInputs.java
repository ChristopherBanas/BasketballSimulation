package controller.ValidInputs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Desc: Class for holding the sets of all valid user inputs for creating a player
 * Author: Christopher Banas
 */
public class PlayerInputs {

    public static Set<String> positionSet = new HashSet<>(Arrays.asList("Point_guard", "Shooting_guard",
            "Small_forward", "Power_forward", "Center"));

    public static Set<String> roleSet = new HashSet<>(Arrays.asList("Superstar", "Star", "Starter",
            "Sixth_man", "Bench"));

    public static Set<String> typeSet = new HashSet<>(Arrays.asList("Three_and_D", "All_around", "Offensive_playmaker",
            "Defensive_playmaker", "Playmaker", "Energetic_rebounder", "Three_level_scorer", "Post_player",
            "In_out_defender", "Pure_shooter", "Stretch_big", "Inside_defender", "Perimeter_defender", "Paint_beast",
            "Offensive_superstar", "Point_god", "Balanced_superstar", "Lockdown_defender", "Two_war_superstar", "God"));

}
