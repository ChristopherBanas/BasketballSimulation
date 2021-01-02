package model;

import java.util.Objects;

/**
 * Desc: Class for coach information
 * Author: Christopher Banas
 */
public class Coach {

    /** Name of coach */
    private String name;
    /** Age of coach */
    private int age;
    /** Team of coach */
    private Team team;

    /**
     * Constructor for Coach when team isn't known
     * @param name Name of coach
     * @param age Age of coach
     */
    public Coach(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * Constructor for Coach when team is known
     * @param name Name of coach
     * @param age Age of coach
     */
    public Coach(String name, int age, Team team){
        this.name = name;
        this.age = age;
        this.team = team;
    }

    /**
     * Getter for name
     * @return Name of coach
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for age
     * @return Age of coach
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter for age
     * @param age New age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter for team
     * @return Team of coach
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Setter for team
     * @param team New team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Prints Coach
     * @return String of Coach
     */
    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", team=" + team +
                '}';
    }

    /**
     * Equals method for coach
     * @param o Coach to be compared to
     * @return If coach is the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return age == coach.age &&
                Objects.equals(name, coach.name) &&
                Objects.equals(team, coach.team);
    }

    /**
     * Hash method for coach
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, team);
    }
}
