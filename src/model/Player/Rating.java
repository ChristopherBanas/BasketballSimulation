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
            case Three_and_D:
                generateFields(4, 9, 9, 9, 5, 7);
                break;
            case All_around:
                generateFields(7, 6, 6, 7, 7, 6);
                break;
            case Offensive_playmaker:
                generateFields(6, 6, 9, 9, 9, 4);
                break;
            case Defensive_playmaker:
                generateFields(8, 8, 9, 7, 5, 4);
                break;
            case Playmaker:
                generateFields(7, 7, 9, 9, 8, 4);
                break;
            case Energetic_rebounder:
                generateFields(9, 5, 4, 5, 9, 9);
                break;
            case Three_level_scorer:
                generateFields(5, 5, 7, 9, 9, 7);
                break;
            case Post_player:
                generateFields(9, 4, 5, 7, 9, 8);
                break;
            case In_out_defender:
                generateFields(8, 8, 7, 4, 4, 9);
                break;
            case Perimeter_defender:
                generateFields(6, 9, 9, 8, 4, 8);
                break;
            case Inside_defender:
                generateFields(9, 6, 8, 4, 8, 9);
                break;
            case Pure_shooter:
                generateFields(4, 7, 9, 9, 9, 8);
                break;
            case Stretch_big:
                generateFields(4, 6, 6, 7, 9, 9);
                break;
            case Paint_beast:
                generateFields(9, 0, 0, 0, 9, 8);
                break;
            case Offensive_superstar:
                generateFields(0, 0, 8, 9, 9, 5);
                break;
            case Point_god:
                generateFields(2, 5, 8, 9, 2, 0);
                break;
            case Balanced_superstar:
                generateFields(3, 3, 3, 5, 5, 3);
                break;
            case Lockdown_defender:
                generateFields(6, 6, 6, 0, 0, 7);
                break;
            case Two_way_superstar:
                generateFields(3, 3, 6, 2, 2, 8);
                break;
            case God:
                generateFields(0, 0, 0, 0, 0, 0);
                break;
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
        switch (tier) {
            case 0:
                return (int) (Math.random() * (99 - 90 + 1) + 90); //tier 0: 99-90
            case 1:
                return (int) (Math.random() * (90 - 80 + 1) + 80); //tier 1: 90-80
            case 2:
                return (int) (Math.random() * (80 - 70 + 1) + 70); //tier 2: 80-70
            case 3:
                return (int) (Math.random() * (70 - 65 + 1) + 65); //tier 3: 70-65 (star only)
            case 4:
                return (int) (Math.random() * (60 - 50 + 1) + 50); //tier 4: 60-50
            case 5:
                return (int) (Math.random() * (50 - 40 + 1) + 40); //tier 5: 50-40
            case 6:
                return (int) (Math.random() * (40 - 30 + 1) + 30); //tier 6: 40-30
            case 7:
                return (int) (Math.random() * (30 - 20 + 1) + 20); //tier 7: 30-20
            case 8:
                return (int) (Math.random() * (20 - 10 + 1) + 10); //tier 8: 20-10
            case 9:
                return (int) (Math.random() * (10 - 1 + 1) + 1); //tier 9: 10-1
            default:
                return 50;
        }
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
