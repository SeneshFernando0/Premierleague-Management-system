import java.io.Serializable;
import java.util.Objects;

public class SheduledDate implements Serializable {
		private int day;
		private int month;


    public SheduledDate(int day, int month){
			this.day = day;                          //Assigning the Variables
			this.month = month;
		}

    //Creating getters and setters
    public int getDay(){
			return day;
		}
    public void setDay(int day){
			this.day = day;
		}
    public int getMonth(){
			return month;
		}
    public void setMonth(int month){
			this.month = month;
		}

    @Override
		public String toString() {               //Creating a toString
			return "SheduledDate{" +
					"day =" + day +
					", month =" + month +
					'}';
		}

    @Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof SheduledDate)) return false;
			SheduledDate that = (SheduledDate) o;
			return getDay() == that.getDay() &&
                getMonth() == that.getMonth();
		}

    @Override
		public int hashCode() {
			return Objects.hash(getDay(), getMonth());
		}
}
