package model;

import java.util.Objects;

/**
 * Desc: Class for game information
 * Author: Christopher Banas
 */
public class Game {

    /** Team one */
    private Team team1;
    /** Team two */
    private Team team2;
    /** Team one score */
    private int team1Score;
    /** Team two score */
    private int team2Score;
    /** Winner of game */
    private Team winner;
    /** Loser of game */
    private Team loser;

    /**
     * Constructor for Game
     * @param team1 Team one
     * @param team2 Team two
     */
    public Game(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = 0;
        this.team2Score = 0;
    }

    /**
     * Getter for team one
     * @return Team one
     */
    public Team getTeam1() {
        return team1;
    }

    /**
     * Getter for team two
     * @return Team two
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * Getter for team one score
     * @return Team one score
     */
    public int getTeam1Score() {
        return team1Score;
    }

    /**
     * Setter for team one score
     * @param team1Score New score
     */
    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    /**
     * Getter for team two score
     * @return Team two score
     */
    public int getTeam2Score() {
        return team2Score;
    }

    /**
     * Setter for team twp score
     * @param team2Score New score
     */
    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    /**
     * Getter for winner
     * @return Winner of game
     */
    public Team getWinner() {
        return winner;
    }

    /**
     * Setter for winner
     * @param winner Winner of game
     */
    public void setWinner(Team winner) {
        this.winner = winner;
    }

    /**
     * Getter for loser
     * @return Loser of game
     */
    public Team getLoser() {
        return loser;
    }

    /**
     * Setter for loser
     * @param loser Loser of game
     */
    public void setLoser(Team loser) {
        this.loser = loser;
    }

    /**
     * Equals method for game
     * @param o Game to be compared
     * @return If game is the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return team1Score == game.team1Score &&
                team2Score == game.team2Score &&
                Objects.equals(team1, game.team1) &&
                Objects.equals(team2, game.team2) &&
                Objects.equals(winner, game.winner) &&
                Objects.equals(loser, game.loser);
    }

    /**
     * Hash method for game
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(team1, team2, team1Score, team2Score, winner, loser);
    }

    /**
     * To string method of game
     * @return String of game
     */
    @Override
    public String toString() {
        return "Game{" +
                "team1=" + team1.getName() +
                ", team2=" + team2.getName() +
                ", team1Score=" + team1Score +
                ", team2Score=" + team2Score +
                ", winner=" + winner.getName() +
                ", loser=" + loser.getName() +
                '}';
    }
}
