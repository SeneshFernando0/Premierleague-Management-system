import java.io.Serializable;
import java.util.Objects;

// Creating Sub classe as universityfootballclub
public class universityfootballclub extends footballclub{
		private String university_Name;
		private int age;

    // Add variables to the sub class
    public universityfootballclub(){
			super();
		}                //Creating a null method
    public universityfootballclub(String Club_Name, String Location, int age, String university_Name, int points, int wins, int draws, int defeats, int goals_scored, int no_of_goals_received, int no_of_matches_played){
			super(Club_Name, Location, points, wins, draws, defeats, goals_scored,no_of_goals_received, no_of_matches_played);
			this.university_Name = university_Name;               //Assigning variables
			this.age = age;
		}

    // Create getter and setter to the sub class
    public String getUniversity_Name(){
			return university_Name;
		}
    public void setUniversity_Name(String university_Name){
			this.university_Name = university_Name;
		}
    public int getAge(){
			return age;
		}
    public void setAge(int age){
			this.age = age;
		}

    // Display the output as below
    @Override
		public String toString() {
			return "universityfootballclub{" + super.toString() +
					" university name = " + university_Name +
					" age = " + age +
					'}';
		}
}
