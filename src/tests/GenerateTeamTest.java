package tests;

import model.Autogeneration.GenerateTeam;
import model.Autogeneration.data.TeamList;
import model.Player.Role;
import model.Player.Type;
import model.Team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateTeamTest {
    private GenerateTeam generator;

    @BeforeEach
    void setUp() {
        generator = new GenerateTeam();
    }


    @Test
    void generateGodTeam(){
        Team team = generator.generateGodTeam();
        int amount = 0;
        for(int i =0; i < team.getRoster().size(); i++){
            Type type = team.getRoster().get(i).getType();
            if(type.equals(Type.God)){
                amount += 1;
            }
        }
        assertEquals(amount, 5);
    }

    @Test
    void generateSuperTeam(){
        Team team = generator.generateSuperTeam();
        int amount = 0;
        for(int i =0; i < team.getRoster().size(); i++){
            Role role = team.getRoster().get(i).getRole();
            if(role.equals(Role.Superstar) || role.equals(Role.Star)){
                amount += 1;
            }
        }
        assertEquals(amount, 3);
    }

    @Test
    void generateContendingTeam(){
        Team team = generator.generateContendingTeam();
        int amount = 0;
        for(int i =0; i < team.getRoster().size(); i++){
            Role role = team.getRoster().get(i).getRole();
            if(role.equals(Role.Superstar) || role.equals(Role.Star)){
                amount += 1;
            }
        }
        assertEquals(amount, 2);
    }

    @Test
    void generatePlayoffTeam(){
        Team team = generator.generatePlayoffTeam();
        int amount = 0;
        for(int i =0; i < team.getRoster().size(); i++){
            Role role = team.getRoster().get(i).getRole();
            if(role.equals(Role.Star)){
                amount += 1;
            }
        }
        assertTrue(amount == 1 || amount == 2);
    }

    @Test
    void generateAverageTeam(){
        Team team = generator.generateAverageTeam();
        int amount = 0;
        for(int i =0; i < team.getRoster().size(); i++){
            Role role = team.getRoster().get(i).getRole();
            if(role.equals(Role.Starter)){
                amount += 1;
            }
        }
        assertEquals(amount, 5);
    }
}