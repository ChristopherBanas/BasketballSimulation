package model.Simulations;

import model.Player;

public class PlayerStats {

    private Player player;
    private int threePointers = 0;
    private int twoPointers = 0;
    private int rebounds = 0;
    private int assists = 0;

    public PlayerStats(Player player, int threePointers, int twoPointers, int rebounds, int assists) {
        this.player = player;
        this.threePointers = threePointers;
        this.twoPointers = twoPointers;
        this.rebounds = rebounds;
        this.assists = assists;
    }

    public int getThreePointers() {
        return threePointers;
    }

    public int getTwoPointers() {
        return twoPointers;
    }

    public int getRebounds() {
        return rebounds;
    }

    public int getAssists() {
        return assists;
    }

    @Override
    public String toString() {
        return "PlayerStats{" +
                "player=" + player.getName() +
                ", threePointers=" + threePointers +
                ", twoPointers=" + twoPointers +
                ", rebounds=" + rebounds +
                ", assists=" + assists +
                '}';
    }
}
