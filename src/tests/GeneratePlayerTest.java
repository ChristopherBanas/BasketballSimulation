package tests;

import model.Autogeneration.GeneratePlayer;
import model.Player.Player;
import model.Player.Position;
import model.Player.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class GeneratePlayerTest {
    GeneratePlayer generator;

    @BeforeEach
    void setUp(){
        generator = new GeneratePlayer();
    }

    @Test
    void createPlayer(){
        for(int i = 0; i<10; i++){
            Player player = generator.createPlayer();
            assertAll(() -> assertNotNull(player.getName()),
                    () -> assertNotNull(player.getAge()),
                    () -> assertNotNull(player.getPosition()),
                    () -> assertNotNull(player.getRating()),
                    () -> assertNotNull(player.getType()),
                    () -> assertNotNull(player.getRole()));
        }
    }


}