package tests;

import model.PlayerType;
import model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {

    private Rating rating;

    @BeforeEach
    void setUp() {
        rating = new Rating(PlayerType.GOD);
    }

    @Test
    void generateRating(){
        assertAll(() -> assertTrue(rating.generateRating(1) >= 85 && rating.generateRating(1) <= 99),
                () -> assertTrue(rating.generateRating(2) >= 70 && rating.generateRating(2) <= 80),
                () -> assertTrue(rating.generateRating(3) >= 60 && rating.generateRating(3) <= 70),
                () -> assertTrue(rating.generateRating(4) >= 50 && rating.generateRating(4) <= 60),
                () -> assertTrue(rating.generateRating(5) >= 40 && rating.generateRating(5) <= 50),
                () -> assertTrue(rating.generateRating(6) >= 30 && rating.generateRating(6) <= 40),
                () -> assertEquals(50, rating.generateRating(7)));
    }


}