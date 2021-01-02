package tests;

import model.Player;
import model.PlayerType;
import model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Lebron James", 35, new Rating(99, 85, 90));
    }

    @Test
    void getType() {
        assertEquals(PlayerType.OFFENSE, player.getType());
    }

    @Test
    void updateType() {
        player.setRating(new Rating(80,99,90));
        assertEquals(PlayerType.DEFENSE, player.getType());
    }
}