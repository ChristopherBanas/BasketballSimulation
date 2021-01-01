package tests;

import model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {

    private Rating rating;

    @BeforeEach
    void setUp() {
        rating = new Rating(99,99,99);
    }

    @Test
    void checkValue() {
        assertAll(() -> assertEquals(99, rating.checkValue(100)),
                () -> assertEquals(99, rating.checkValue(500)),
                () -> assertEquals(1, rating.checkValue(0)),
                () -> assertEquals(1, rating.checkValue(-500)),
                () -> assertEquals(1, rating.checkValue(1)),
                () -> assertEquals(99, rating.checkValue(99)));
    }

    @Test
    void getOffense() {
        assertEquals(99, rating.getOffense());
    }

    @Test
    void setOffense() {
        rating.setOffense(87);
        assertEquals(87, rating.getOffense());
        rating.setOffense(0);
        assertEquals(1, rating.getOffense());
    }

    @Test
    void getDefense() {
        assertEquals(99, rating.getDefense());
    }

    @Test
    void setDefense() {
        rating.setDefense(87);
        assertEquals(87, rating.getDefense());
        rating.setDefense(0);
        assertEquals(1, rating.getDefense());
    }

    @org.junit.jupiter.api.Test
    void getAthleticism() {
        assertEquals(99, rating.getAthleticism());
    }

    @Test
    void setAthleticism() {
        rating.setAthleticism(87);
        assertEquals(87, rating.getAthleticism());
        rating.setAthleticism(0);
        assertEquals(1, rating.getAthleticism());
    }

    @Test
    void getOverall() {
        assertEquals(99, rating.getOverall());
    }

    @Test
    void updateOverall() {
        rating.setOffense(90);
        rating.setDefense(80);
        rating.setAthleticism(70);
        rating.updateOverall();
        assertEquals(80, rating.getOverall());
    }
}