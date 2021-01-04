package model;

import java.util.Objects;

/**
 * Desc: Class for player rating information
 * Author: Christopher Banas
 */
public class Rating {

    private int outsideShotRating;
    private int insideShotRating;
    private int reboundRating;
    private int insideDefenseRating;
    private int outsideDefenseRating;
    private int passingRating;


    public Rating(PlayerType type){
        switch (type) {
            case SHARPSHOOTER -> {
                this.outsideShotRating = generateRating(1);
                this.insideShotRating = generateRating(6);
                this.reboundRating = generateRating(4);
                this.insideDefenseRating = generateRating(6);
                this.outsideDefenseRating = generateRating(2);
                this.passingRating = generateRating(3);
            }
            case PLAYMAKER -> {
                this.outsideShotRating = generateRating(2);
                this.insideShotRating = generateRating(4);
                this.reboundRating = generateRating(6);
                this.insideDefenseRating = generateRating(5);
                this.outsideDefenseRating = generateRating(3);
                this.passingRating = generateRating(1);
            }
            case REBOUNDER -> {
                this.outsideShotRating = generateRating(5);
                this.insideShotRating = generateRating(3);
                this.reboundRating = generateRating(1);
                this.insideDefenseRating = generateRating(2);
                this.outsideDefenseRating = generateRating(5);
                this.passingRating = generateRating(6);
            }
            case INSIDE_SCORER -> {
                this.outsideShotRating = generateRating(4);
                this.insideShotRating = generateRating(1);
                this.reboundRating = generateRating(2);
                this.insideDefenseRating = generateRating(4);
                this.outsideDefenseRating = generateRating(6);
                this.passingRating = generateRating(5);
            }
            case WELL_ROUNDED -> {
                this.outsideShotRating = generateRating(3);
                this.insideShotRating = generateRating(2);
                this.reboundRating = generateRating(3);
                this.insideDefenseRating = generateRating(3);
                this.outsideDefenseRating = generateRating(4);
                this.passingRating = generateRating(2);
            }
            case DEFENSIVE_MINDED -> {
                this.outsideShotRating = generateRating(6);
                this.insideShotRating = generateRating(5);
                this.reboundRating = generateRating(4);
                this.insideDefenseRating = generateRating(1);
                this.outsideDefenseRating = generateRating(1);
                this.passingRating = generateRating(4);
            }
            case GOD -> {
                this.outsideShotRating = 90;
                this.insideShotRating = 90;
                this.reboundRating = 90;
                this.insideDefenseRating = 90;
                this.outsideDefenseRating = 90;
                this.passingRating = 90;
            }
        }
    }

    public int generateRating(int tier){
        return switch (tier) {
            case 1 -> (int) (Math.random() * (99 - 85 + 1) + 85);
            case 2 -> (int) (Math.random() * (80 - 70 + 1) + 70);
            case 3 -> (int) (Math.random() * (70 - 60 + 1) + 60);
            case 4 -> (int) (Math.random() * (60 - 50 + 1) + 50);
            case 5 -> (int) (Math.random() * (50 - 40 + 1) + 40);
            case 6 -> (int) (Math.random() * (40 - 30 + 1) + 30);
            default -> 5;
        };
    }

    public int getOutsideShotRating() {
        return outsideShotRating;
    }

    public int getInsideShotRating() {
        return insideShotRating;
    }

    public int getReboundRating() {
        return reboundRating;
    }

    public int getInsideDefenseRating() {
        return insideDefenseRating;
    }

    public int getOutsideDefenseRating() {
        return outsideDefenseRating;
    }

    public int getPassingRating() {
        return passingRating;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(outsideShotRating, insideShotRating, reboundRating,
                insideDefenseRating, outsideDefenseRating, passingRating);
    }

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
