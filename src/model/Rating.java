package model;

/**
 * Desc: Class for player rating information
 * Author: Christopher Banas
 */
public class Rating {

    /** Offense rating of a player */
    private int offense;
    /** Defensive rating of a player */
    private int defense;
    /** Athletic rating of a player */
    private int athleticism;
    /** Overall rating of a player */
    private int overall;

    /**
     * Constructor for Rating
     * @param offense Offensive rating
     * @param defense Defensive rating
     * @param athleticism Athletic rating
     */
    public Rating(int offense, int defense, int athleticism){
        offense = checkValue(offense);
        defense = checkValue(defense);
        athleticism = checkValue(athleticism);
        this.offense = offense;
        this.defense = defense;
        this.athleticism = athleticism;
        this.overall = ((offense + defense + athleticism)/3);
    }

    /**
     * Makes sure the given value is within the bounds of 1-99
     * @param value Value to be checked
     * @return Corrected version of value if needed
     */
    public int checkValue(int value){
        if(value > 99){
            System.out.println("[MODEL-RATING] Value too high, reducing to 99");
            value = value - (value - 99);
        } else if(value <= 0){
            System.out.println("[MODEL-RATING] Value too low, increasing to 1");
            value = 1;
        }
        return value;
    }

    /**
     * Getter for offense
     * @return Offensive rating
     */
    public int getOffense() {
        return offense;
    }

    /**
     * Setter for offense
     * @param offense New offensive value
     */
    public void setOffense(int offense) {
        offense = checkValue(offense);
        this.offense = offense;
    }

    /**
     * Getter for defense
     * @return Defensive rating
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Setter for defense
     * @param defense New defensive rating
     */
    public void setDefense(int defense) {
        defense = checkValue(defense);
        this.defense = defense;
    }

    /**
     * Getter for athleticism
     * @return Athletic rating
     */
    public int getAthleticism() {
        return athleticism;
    }

    /**
     * Setter for athleticism
     * @param athleticism New athletic rating
     */
    public void setAthleticism(int athleticism) {
        athleticism = checkValue(athleticism);
        this.athleticism = athleticism;
    }

    /**
     * Getter for overall rating
     * @return Overall rating
     */
    public int getOverall() {
        return overall;
    }

    /**
     * Update overall rating with current ratings
     */
    public void updateOverall() {
        this.overall = ((this.offense + this.defense + this.athleticism)/3);
    }
}
