package tests;

import model.Player.Player;
import model.Player.Position;
import model.Player.Role;
import model.Player.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Lebron James", 35, Type.All_around,
                Role.Starter, Position.Small_forward);
    }

    @Test
    void getType() {
        assertEquals(Type.All_around, player.getType());
    }

    @Test
    void increaseAge() {
        player.increaseAge();
        assertEquals(36, player.getAge());
    }

}