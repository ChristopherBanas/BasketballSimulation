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
        player = new Player("Lebron James", 35, Type.ALL_AROUND,
                Role.STAR, Position.SMALL_FORWARD);
    }

    @Test
    void getType() {
        assertEquals(Type.ALL_AROUND, player.getType());
    }

    @Test
    void increaseAge() {
        player.increaseAge();
        assertEquals(36, player.getAge());
    }

}