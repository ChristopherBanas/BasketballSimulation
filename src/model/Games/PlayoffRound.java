package model.Games;

import model.Team.Team;

public class PlayoffRound {

    private Team winner;
    private int winnerWins;
    private Team loser;
    private int loserWins;
    private String round;

    public PlayoffRound(Team winner, int winnerWins, Team loser, int loserWins, String round){
        this.winner = winner;
        this.winnerWins = winnerWins;
        this.loser = loser;
        this.loserWins = loserWins;
        this.round = round;
    }

    public Team getWinner() {
        return winner;
    }

    public int getWinnerWins() {
        return winnerWins;
    }

    public Team getLoser() {
        return loser;
    }

    public int getLoserWins() {
        return loserWins;
    }

    @Override
    public String toString() {
        return String.format("| %s playoff results\n", round) +
                String.format("| Winner: %s (%s-%s) over %s (%s-%s)\n", winner.getName(), winnerWins,
                        loserWins, loser.getName(), loserWins, winnerWins);
    }
}
