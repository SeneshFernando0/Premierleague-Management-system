import javafx.application.Application;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
// Creating console application as main
public class Main {
    // Taking the leaguemanager data through premeireleague class
    private static Leaguemanager premeireleague = new PremeireLeague();

    // Creating the add club method in console
    public static void addclub(){
        Scanner sc = new Scanner(System.in);   //Taking user inputs
        Sports_Club sports_club = null;       // Making sports_club class as null

        while(true) {                        // Creating infinite loop
            try {
                System.out.print("Enter a Foot Ball Club Name : ");
                String footballclubname = sc.nextLine().toLowerCase();       //Taking string value as user input

                System.out.print("Enter the Foot Ball Club Location : ");
                String footballclublocation = sc.nextLine().toLowerCase();  //Taking String value as user input

                System.out.print("Enter the age of the Foot Ball Club : ");
                int age = sc.nextInt();                                    //Taking int input

                System.out.print("Enter no of wins : ");
                int wins = sc.nextInt();                                  //Taking int input

                System.out.print("Enter no of draws : ");
                int draws = sc.nextInt();                                //Taking int input

                System.out.print("Enter no of defeats : ");
                int defeats = sc.nextInt();                             //Taking int input

                System.out.print("Enter no of goals scored : ");
                int goals_scored = sc.nextInt();                       //Taking int inout

                System.out.print("Enter no of goals received : ");
                int goals_received = sc.nextInt();                    //Taking int input

                System.out.print("No matches played : ");
                int matches_played = wins + draws + defeats;         //Taking no of matches palyed using adding wins, defeats and draws
                System.out.println(matches_played);

                System.out.print("No of points gain : ");
                int points = wins * 2 + draws * 1;                      //Taking no of points for 1 win 2 points and and for 1 draw 1 point
                System.out.println(points);

                if (age <= 18) {                                    //Making age
                    sc.nextLine();
                    System.out.println("Enter the School Name : ");
                    String schoolname1 = sc.nextLine();             // Taking school name as String user input
                    sports_club = new schoolfootballclub(footballclubname, footballclublocation, age, schoolname1, points, wins, draws, defeats, goals_scored, goals_received, matches_played); //Adding all data to the schoolfootballclub through sports_culb
                    break;
                }
                if (18 < age || age <= 23) {                        //Making age
                    sc.nextLine();
                    System.out.print("Enter the University Name : ");
                    String universityname = sc.nextLine().toLowerCase();

                    sports_club = new universityfootballclub(footballclubname, footballclublocation, age, universityname, points, wins, draws, defeats, goals_scored, goals_received, matches_played);
                    break;
                } else {
                    System.out.print("Invalid inputs please change the inputs ...!!!");      // Giving a successfull massage if user input wrong data
                    return;
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid Input Please Enter again..............");
                return;
            }
        }
        premeireleague.addFootballClub(sports_club);                          // add data to the premeireleague addfootclub method
    }
    public static void displayfootballclubs(){
        premeireleague.viewFootballclub();
    }  //Display all the football club
    public static void deletefootballClub(){               //user can delete entered football club
        System.out.println("Enter the Football club name to remove: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().toLowerCase();          //Taking user input to delete the football club
        premeireleague.deleteFootballClub(name);
    }
    public static void displaypremeireleaguetable(){    //Display the premeire league table
        premeireleague.displayPremeireLeagueTable();
    }
    public static void displayTeamStatistics(){         //Display the team statistics to the selected team
        System.out.print("Enter Club Name : ");
        Scanner sc = new Scanner(System.in);           //Taking user input to select a team
        String clubname = sc.nextLine().toLowerCase();
        premeireleague.displayteamstatistics(clubname);
    }
    public static void matchplayed() throws IOException {              // Creating played match method
        Scanner sc = new Scanner(System.in);       // Taking user inputs
        played_match PlayedMatch = null;          // making playedMatch as null

        try {
            System.out.println("Enter the Home Team: ");
            String home_team = sc.nextLine();           //Taking user inputs
            System.out.print(home_team);

            System.out.println("Enter the name of the Away Team: ");
            String away_team = sc.nextLine();         // Taking user inputs
            System.out.print(away_team);

            System.out.print("Enter Match Day: ");
            int day = sc.nextInt();                    // Taking user inputs

            if (day > 31) {                             // If date is greater than 31 days display error
                System.out.println("Dates should between 1- 30 or 1 - 31");
                return;
            }

            System.out.print("Enter Match Month: ");
            int month = sc.nextInt();

            if (month > 12) {                          // If month is greater than 12 display error
                System.out.println("12 months per year");
                return;
            }

            System.out.println("Enter Goal scored by Home team: ");
            int goals = sc.nextInt();         // Taking user inputs

            System.out.println("Enter Goal scored by Away Team: ");
            int recieved = sc.nextInt();    // Taking user inputs

            SheduledDate matchdate = new SheduledDate(day, month);           //Add data to the date class
            PlayedMatch = new played_match(home_team, away_team, matchdate, goals, recieved);   //Add data to the Playedmatch class

            premeireleague.Played_match(PlayedMatch);
        }catch (InputMismatchException e){
            System.out.println("Invalid Input Please Enter again...........");
            return;
        }
    }
    public static void main(String [] args) throws IOException, ClassNotFoundException {
        premeireleague.readfile("Data.txt");                                //Load the saved data file
        menuList:
        while(true){                                                               // Creating infinite loop
            System.out.println("Press '1' to add FootBall Club");
            System.out.println("Press '2' to view the FootBall Clubs");
            System.out.println("Press '3' to delete existing the Football Club");    //Creating menulist
            System.out.println("Press '4' to Display Premier League");
            System.out.println("Press '5' to Display the selected Team Statistics");
            System.out.println("Press '6' to Play a match");
            System.out.println("Press '7' to End the programme");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Your Choice : ");          //Taking user choice
            int user_choice = sc.nextInt();

            switch (user_choice){                            // Switch case
                case 1:
                    addclub();                                         //Add club method
                    break;
                case 2:
                    System.out.println("Football Clubs");
                    displayfootballclubs();                             //Display all club method
                    break;
                case 3:
                    deletefootballClub();                              //Delete club method
                    break;
                case 4:
                    displaypremeireleaguetable();                      //Display premeire league table
                    break;
                case 5:
                    displayTeamStatistics();                            //Display statistics to a selected club
                    break;
                case 6:
                    matchplayed();                                       //add a played match
                    break;
                case 7:
                    premeireleague.savetofile("Data.txt");       // Save the data to the file
                    break;
                case 8:
                    System.out.println("Graphical User Interface Loading............");
                    Application.launch(GUI.class,args);               //Launching the GUI Application through Console
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Enter a valid Input !!!!!");     //If user input wrong data display error massage
                    continue;
            }
        }
    }
}
