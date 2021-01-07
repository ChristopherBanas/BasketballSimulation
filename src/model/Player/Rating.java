package model.Player;

import java.util.Objects;

/**
 * Desc: Class for player rating information
 * Author: Christopher Banas
 */
public class Rating {

    /** How well a player shoots from outside (0-100) */
    private int outsideShotRating;
    /** How well a player shoots from inside (0-100) */
    private int insideShotRating;
    /** How well a player rebounds (0-100) */
    private int reboundRating;
    /** How well a player defends inside (0-100) */
    private int insideDefenseRating;
    /** How well a player defends outside (0-100) */
    private int outsideDefenseRating;
    /** How well a player passes (0-100) */
    private int passingRating;

    /**
     * Constructor for Rating
     * @param type Type of this player
     */
    public Rating(Type type){
        switch (type) {
            case THREE_AND_D -> generateFields(1, 5, 8, 3, 1, 6);
            case ALL_AROUND -> generateFields(4,4,4,4,4,4);
            case PAINT_BEAST -> generateFields(8,1,1,1,7,6);
            case OFFENSIVE_PLAYMAKER -> generateFields(2,2,8,6,5,1);
            case DEFENSIVE_PLAYMAKER -> generateFields(8,6,6,2,1,1);
            case HIGH_ENERGY -> generateFields(6,5,1,2,4,6);
            case THREE_LEVEL_SCORER -> generateFields(1,1,4,7,7,4);
            case POST_PLAYER -> generateFields(8,1,1,4,6,4);
            case DEFENSIVE_MINDED -> generateFields(6,5,5,1,1,6);
            case PURE_SHOOTER -> generateFields(1,3,6,8,8,6);
            case GOD -> generateFields(0,0,0,0,0,0);
        }
    }

    /**
     * Generate fields given tiers of attributes
     * @param out Outside shot tier
     * @param inside Inside shot tier
     * @param rebound Rebounding tier
     * @param inD Inside defense tier
     * @param outD Outside defense tier
     * @param pass Passing tier
     */
    public void generateFields(int out, int inside, int rebound, int inD, int outD, int pass){
        this.outsideShotRating = generateRating(out);
        this.insideShotRating = generateRating(inside);
        this.reboundRating = generateRating(rebound);
        this.insideDefenseRating = generateRating(inD);
        this.outsideDefenseRating = generateRating(outD);
        this.passingRating = generateRating(pass);
    }

    /**
     * Randomly generates a rating given a tier
     * @param tier Tier to be generated
     * @return Rating number
     */
    public int generateRating(int tier){
        return switch (tier) {
            case 0 -> (int) (Math.random() * (99 - 90 + 1) + 90); //tier 0: 99-90
            case 1 -> (int) (Math.random() * (90 - 80 + 1) + 80); //tier 1: 90-80
            case 2 -> (int) (Math.random() * (80 - 70 + 1) + 70); //tier 2: 80-70
            case 3 -> (int) (Math.random() * (70 - 60 + 1) + 60); //tier 3: 70-60
            case 4 -> (int) (Math.random() * (60 - 50 + 1) + 50); //tier 4: 60-50
            case 5 -> (int) (Math.random() * (50 - 40 + 1) + 40); //tier 5: 50-40
            case 6 -> (int) (Math.random() * (40 - 30 + 1) + 30); //tier 6: 40-30
            case 7 -> (int) (Math.random() * (30 - 20 + 1) + 20); //tier 6: 30-20
            case 8 -> (int) (Math.random() * (20 - 10 + 1) + 10); //tier 6: 20-10
            default -> 50;
        };
    }

    /**
     * Getter for outside shot rating
     * @return Outside shot rating
     */
    public int getOutsideShotRating() {
        return outsideShotRating;
    }

    /**
     * Getter for inside shot rating
     * @return Inside shot rating
     */
    public int getInsideShotRating() {
        return insideShotRating;
    }

    /**
     * Getter for rebounding rating
     * @return Rebounding rating
     */
    public int getReboundRating() {
        return reboundRating;
    }

    /**
     * Getter for inside defense rating
     * @return Inside defense rating
     */
    public int getInsideDefenseRating() {
        return insideDefenseRating;
    }

    /**
     * Getter for outside defense rating
     * @return Outside defense rating
     */
    public int getOutsideDefenseRating() {
        return outsideDefenseRating;
    }

    /**
     * Getter for passing rating
     * @return Passing rating
     */
    public int getPassingRating() {
        return passingRating;
    }

    /**
     * Equals method for rating
     * @param o Rating to be compared
     * @return If equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return outsideShotRating == rating.outsideShotRating &&
                insideShotRating == rating.insideShotRating &&
                reboundRating == rating.reboundRating &&
                insideDefenseRating == rating.insideDefenseRating &&
                outsideDefenseRating == rating.outsideDefenseRating &&
                passingRating == rating.passingRating;
    }

    /**
     * Hash method
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(outsideShotRating, insideShotRating, reboundRating,
                insideDefenseRating, outsideDefenseRating, passingRating);
    }

    /**
     * Prints rating
     * @return String of rating
     */
    @Override
    public String toString() {
        return "Rating{" +
                "outsideShotRating=" + outsideShotRating +
                ", insideShotRating=" + insideShotRating +
                ", reboundRating=" + reboundRating +
                ", insideDefenseRating=" + insideDefenseRating +
                ", outsideDefenseRating=" + outsideDefenseRating +
                ", passingRating=" + passingRating +
                '}';
    }
}
