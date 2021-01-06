package model.Simulations;

import model.Player.Player;

import java.util.Objects;

/**
 * Desc: Class for player stats of a simulation
 * Author: Christopher Banas
 */
public class PlayerStats {

    /** Player whose stats these are */
    private Player player;
    /** Total points scored by player */
    private int totalPoints = 0;
    /** Total three pointers made by player */
    private int threePointers = 0;
    /** Total field goals made by player */
    private int fieldGoals = 0;
    /** Total rebounds grabbed by player */
    private int rebounds = 0;
    /** Total assists made by player */
    private int assists = 0;

    /**
     * Constructor for PlayerStats
     * @param player Player whose stats these are
     * @param threePointers Three pointers made
     * @param twoPointers Two pointers made
     * @param rebounds Rebounds grabbed
     * @param assists Assists made
     */
    public PlayerStats(Player player, int threePointers, int twoPointers, int rebounds, int assists) {
        this.player = player;
        this.totalPoints = ((threePointers * 3) + (twoPointers * 2));
        this.threePointers = threePointers;
        this.fieldGoals = threePointers + twoPointers;
        this.rebounds = rebounds;
        this.assists = assists;
    }

    /**
     * Getter for three pointers
     * @return Three pointers made
     */
    public int getThreePointers() {
        return threePointers;
    }

    /**
     * Getter for field goals
     * @return Field goals made
     */
    public int getFieldGoals() {
        return fieldGoals;
    }

    /**
     * Getter for rebounds
     * @return Rebounds grabbed
     */
    public int getRebounds() {
        return rebounds;
    }

    /**
     * Getter for assists
     * @return Assists made
     */
    public int getAssists() {
        return assists;
    }

    /**
     * Getter for total points scored
     * @return Points scored by player
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Prints player stats
     * @return String of player stats
     */
    @Override
    public String toString() {
        return "PlayerStats{" +
                "player=" + player.getName() +
                ", totalPoints=" + totalPoints +
                ", threePointers=" + threePointers +
                ", fieldGoals=" + fieldGoals +
                ", rebounds=" + rebounds +
                ", assists=" + assists +
                '}';
    }

    /**
     * Getter for player
     * @return Player whose these stats belong to
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Equals method for player stats
     * @param o Player stats to be compared
     * @return If player stats are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStats that = (PlayerStats) o;
        return totalPoints == that.totalPoints &&
                threePointers == that.threePointers &&
                fieldGoals == that.fieldGoals &&
                rebounds == that.rebounds &&
                assists == that.assists &&
                Objects.equals(player, that.player);
    }

    /**
     * Hash method for player stats
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(player, totalPoints, threePointers, fieldGoals, rebounds, assists);
    }
}
