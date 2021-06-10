import java.io.Serializable;
import java.util.Objects;

// Creating the Parent Class
public abstract class Sports_Club implements Serializable{
		private String Club_Name;
		private String Location;
		private SheduledDate matchdate;

    //Add variables to the Parent Class

		public Sports_Club() {                                   //Creating a Null method

		}

		public Sports_Club(String Club_Name, String Location) {        //Assigning Variables
			this.Club_Name = Club_Name;
			this.Location = Location;
		}

    // Creating getters and setters
		public String getClub_Name(){
			return Club_Name;
		}
		public void setClub_Name(String club_Name){
			this.Club_Name = Club_Name;
		}
		public String getLocation(){
			return Location;
		}
		public void setLocation(String location){
			this.Location = Location;
		}


    //Display the output as below
	@Override
		public String toString() {
			return "Sports_Club{" +
					"Club_Name='" + Club_Name + '\'' +
					", Location='" + Location + '\'' +
					'}';
		}

    @Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Sports_Club)) return false;
			Sports_Club that = (Sports_Club) o;
			return Objects.equals(getClub_Name(), that.getClub_Name()) &&
					Objects.equals(getLocation(), that.getLocation());
		}

	@Override
		public int hashCode() {
			return Objects.hash(getClub_Name(), getLocation());
		}
}