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
            case THREE_AND_D -> generateFields(4,9,9,9,5,7);
            case ALL_AROUND -> generateFields(7,6,6,7,7,6);
            case OFFENSIVE_PLAYMAKER -> generateFields(6,6,9,9,9,4);
            case DEFENSIVE_PLAYMAKER -> generateFields(8,8,9,7,5,4);
            case PLAYMAKER -> generateFields(7,7,9,9,8,4); //TODO
            case ENERGETIC_REBOUNDER -> generateFields(9,5,4,5,9,9);
            case THREE_LEVEL_SCORER -> generateFields(5,5,7,9,9,7);
            case POST_PLAYER -> generateFields(9,4,5,7,9,8);
            case IN_OUT_DEFENDER -> generateFields(8,8,7,4,4,9);
            case PERIMETER_DEFENDER -> generateFields(6,9,9,8,4,8); //TODO
            case INSIDE_DEFENDER -> generateFields(9,6,8,4,8,9);
            case PURE_SHOOTER -> generateFields(4,7,9,9,9,8);
            case STRETCH_BIG -> generateFields(4,6,6,7,9,9); //TODO
            case PAINT_BEAST -> generateFields(9, 0, 0, 0, 9, 8);
            case OFFENSIVE_SUPERSTAR -> generateFields(0,0,8,9,9,5); //TODO
            case POINT_GOD -> generateFields(2,5,8,9,2,0); //TODO
            case BALANCED_SUPERSTAR -> generateFields(3,3,3,5,5,3); //TODO
            case LOCKDOWN_DEFENDER -> generateFields(6,6,6,0,0,7); //TODO
            case TWO_WAY_SUPERSTAR -> generateFields(3,3,6,2,2,8); //TODO
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
            case 3 -> (int) (Math.random() * (70 - 65 + 1) + 65); //tier 3: 70-65 (star only)
            case 4 -> (int) (Math.random() * (60 - 50 + 1) + 50); //tier 4: 60-50
            case 5 -> (int) (Math.random() * (50 - 40 + 1) + 40); //tier 5: 50-40
            case 6 -> (int) (Math.random() * (40 - 30 + 1) + 30); //tier 6: 40-30
            case 7 -> (int) (Math.random() * (30 - 20 + 1) + 20); //tier 7: 30-20
            case 8 -> (int) (Math.random() * (20 - 10 + 1) + 10); //tier 8: 20-10
            case 9 -> (int) (Math.random() * (10 - 1 + 1) + 1); //tier 9: 10-1
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
