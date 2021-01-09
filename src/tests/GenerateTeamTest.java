package tests;

import model.Autogeneration.GenerateTeam;
import model.Autogeneration.data.TeamList;
import model.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class GenerateTeamTest {
    private GenerateTeam generator;

    @BeforeEach
    void setUp() {
        generator = new GenerateTeam();
    }

    @Test
    void generateName() {
        for(int i = 0; i < 4; i++){
            String name = generator.generateName();
            assertTrue(TeamList.teamNameList.contains(name));
        }
    }

    /**
    @Test
    void generateRandomTeamType(){
        for(int i = 0; i < 20; i++){
            System.out.println(generator.generateRandomTeamType());
        }
    }
    */

    @Test
    void generateGodTeam(){
        Team team = generator.generateGodTeam();
        System.out.println(team);
    }
}