package model.Simulations;

public class TotalStats {

    private int offense;
    private int defense;
    private int overall;

    public TotalStats(){
        offense = 0;
        defense = 0;
        overall = 0;
    }

    public int getOffense() {
        return offense;
    }

    public void setOffense(int offense) {
        this.offense += offense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense += defense;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall += overall;
    }
}
