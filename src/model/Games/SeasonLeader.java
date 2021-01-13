package model.Games;

import model.Player.Player;

public class SeasonLeader {

    private Player player;
    private double amount;
    private LeaderType type;

    public SeasonLeader(Player player, double amount, LeaderType type){
        this.player = player;
        this.amount = amount;
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        String top = "";
        String bottom = "|\n";
        if(this.type.equals(LeaderType.threes)){
            top = "| Leader in threes made during season\n";
            bottom = "";
        } else{
            top = String.format("| Leader in %s per game\n", this.type);
        }
        return  top + String.format("| %s (%s)- %s\n", this.player.getName(), player.getTeam().getName(),
                this.amount) + bottom;
    }
}
