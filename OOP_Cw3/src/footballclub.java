// Creating a sub class as footballclub
public class footballclub extends Sports_Club implements Comparable<footballclub>{
		private int wins;
		private int draws;
		private int defeats;
		private Integer goals_scored;
		private Integer no_of_goals_received;
		private Integer no_of_points;
		private Integer difference;
		private int no_of_matches_played;

    // Add variables to the sub class
		public footballclub(String Club_Name, String Location, Integer no_of_points, int wins, int draws, int defeats, Integer goals_scored, Integer no_of_goals_received, int no_of_matches_played) {

			super(Club_Name, Location);                                 //Getting the variables from the Sports club class
			this.wins = wins;
			this.draws = draws;                                         //Assign the variables
			this.defeats = defeats;
			this.goals_scored = goals_scored;
			this.no_of_goals_received = no_of_goals_received;
			this.no_of_points = no_of_points;
			this.no_of_matches_played = no_of_matches_played;
		}

    public footballclub() {
			super();
		}                            //Creating a Null Variable

    // Creating getters and setters
    public int getWins() {
			return wins;
		}

    public int getDraws() {
			return draws;
		}

    public int getDefeats() {
			return defeats;
		}

    public Integer getGoals_scored(){
			return goals_scored;
		}

    public Integer getNo_of_goals_received() {
			return no_of_goals_received;
		}

    public Integer getNo_of_points() {
			return no_of_points;
		}

    public Integer getDifference(){
			return goals_scored-no_of_goals_received;
		}

    public int getNo_of_matches_played() {
			return no_of_matches_played;
		}

    public void setWins(int wins) {
			this.wins = wins;
		}

    public void setDraws(int draws) {
			this.draws = draws;
		}

    public void setDefeats(int defeats) {
			this.defeats = defeats;
		}

    public void setGoals_scored(Integer goals_scored) {
			this.goals_scored = goals_scored;
		}

    public void setNo_of_goals_received(Integer no_of_goals_received) {
			this.no_of_goals_received = no_of_goals_received;
		}

    public void setNo_of_points(Integer no_of_points) {
			this.no_of_points = no_of_points;
		}

    public void setDifference(Integer difference) {
			this.difference = difference;
		}

    public void setNo_of_matches_played(int no_of_matches_played) {
			this.no_of_matches_played = no_of_matches_played;
		}

    // Display the output as below
    @Override
		public String toString() {
			return "Footballclub{" + super.toString() +
					" no_of_points=" + no_of_points +
					",wins=" + wins +
					", draws=" + draws +
					", defeats=" + defeats +
					", goals_scored = " + goals_scored +
					", no_of_goals_received=" + no_of_goals_received +
					", no_of_matches_played=" + no_of_matches_played +
					'}';
		}

    //Getting the Difference between Goals Scored and Goals Received
    @Override
		public int compareTo(footballclub Football_Club) {
			if(this.getNo_of_points().equals(Football_Club.getNo_of_points())){

				return this.getDifference().compareTo(Football_Club.getDifference());

			} else {

				return this.getNo_of_points().compareTo(Football_Club.getNo_of_points());
			}
		}
}