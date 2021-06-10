import java.io.Serializable;

// Creating Sub classe as schoolfootballclub
public class schoolfootballclub extends footballclub {
		private String school_name;
		private int age;

    public schoolfootballclub(){
			super();
		}       	     //Creating a Null method

    // Add variables to the sub class
    public schoolfootballclub(String Club_Name, String Location, int age, String school_name, int points, int wins, int draws, int defeats, int goals_scored, int no_of_goals_received, int no_of_matches_played){
			super(Club_Name, Location, points, wins, draws, defeats, goals_scored, no_of_goals_received, no_of_matches_played);
			this.school_name = school_name;
			this.age = age;                                           //Assigning the Variables
		}

    // Create getter and setter to the sub class
    public String getSchool_name(){
			return school_name;
		}
    public void setSchool_name(String school_name){
			this.school_name = school_name;
		}

    public int getAge(){
			return age;
    }
    public void setAge(int age){
			this.age = age;
    }

    // Display the output as below
    @Override
		public String toString(){
			return  "schoolfootballclub{" + super.toString() +
					"school name = " + school_name +
					"age = " + age +
					'}';
		}
}
