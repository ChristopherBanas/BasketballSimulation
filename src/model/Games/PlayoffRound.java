package model.Games;

import model.Team.Team;

/**
 * Desc: Class for storing winner and loser information for a playoff round
 * Author: Christopher Banas
 */
public class PlayoffRound {

    /** Winner of round */
    private final Team winner;
    /** Amount of wins the winner won (should always be 4) */
    private final int winnerWins;
    /** Loser of round */
    private final Team loser;
    /** Amount of wins the winner won*/
    private final int loserWins;
    /** What round this was */
    private final RoundType roundType;

    /**
     * Constructor for PlayoffRound
     * @param winner Winner of round
     * @param winnerWins Amount of times winner won (should be 4)
     * @param loser Loser of round
     * @param loserWins Amount of times loser won
     * @param roundType What type this round was
     */
    public PlayoffRound(Team winner, int winnerWins, Team loser, int loserWins, RoundType roundType){
        this.winner = winner;
        this.winnerWins = winnerWins;
        this.loser = loser;
        this.loserWins = loserWins;
        this.roundType = roundType;
    }

    /**
     * Getter for round winner
     * @return Team that won
     */
    public Team getWinner() {
        return winner;
    }

    /**
     * Getter for amount of wins the winner won
     * @return Amount of wins
     */
    public int getWinnerWins() {
        return winnerWins;
    }

    /**
     * Getter for round loser
     * @return Team that lost
     */
    public Team getLoser() {
        return loser;
    }

    /**
     * Getter for amount of wins the loser won
     * @return Amount of wins
     */
    public int getLoserWins() {
        return loserWins;
    }

    /**
     * Prints the playoff round
     * @return String of playoff round
     */
    @Override
    public String toString() {
        return String.format("| %s playoff results\n", roundType) +
                String.format("| Winner: %s (%s-%s) over %s (%s-%s)\n", winner.getName(), winnerWins,
                        loserWins, loser.getName(), loserWins, winnerWins);
    }
}
