import java.io.Serializable;

public class played_match implements Serializable {
    private String HomeTeam;
    private String AwayTeam;
    private SheduledDate matchdate;
    private int goalscoredbyhometeam;
    private int goalscoredbyawayteam;

    public played_match(String HomeTeam,String AwayTeam, SheduledDate matchdate, int goalscoredbyhometeam, int goalscoredbyawayteam){
        this.HomeTeam = HomeTeam;
        this.AwayTeam = AwayTeam;                               //Assigning Variables
        this.matchdate = matchdate;
        this.goalscoredbyhometeam = goalscoredbyhometeam;
        this.goalscoredbyawayteam = goalscoredbyawayteam;
    }

    //Creating Getters and Setters
    public String getHomeTeam() {
        return HomeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        HomeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return AwayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        AwayTeam = awayTeam;
    }

    public int getGoalscoredbyhometeam() {
        return goalscoredbyhometeam;
    }

    public SheduledDate getMatchdate(){
        return matchdate;
    }
    public void setMatchdate(SheduledDate matchdate){
        this.matchdate = matchdate;
    }

    public void setGoalscoredbyhometeam(int goalscoredbyhometeam) {
        this.goalscoredbyhometeam = goalscoredbyhometeam;
    }

    public int getGoalscoredbyawayteam() {
        return goalscoredbyawayteam;
    }

    public void setGoalscoredbyawayteam(int goalscoredbyawayteam) {
        this.goalscoredbyawayteam = goalscoredbyawayteam;
    }

    @Override
    public String toString() {                                             //Creating a toString method
        return "played_match{" +
                "HomeTeam='" + HomeTeam + '\'' +
                ", AwayTeam='" + AwayTeam + '\'' +
                ", matchdate=" + matchdate  +
                ", goalscoredbyhometeam=" + goalscoredbyhometeam +
                ", goalscoredbyawayteam=" + goalscoredbyawayteam +
                '}';
    }
}
