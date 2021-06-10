import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Creating a PremeireLeague class implements the interface
public class PremeireLeague implements Leaguemanager {

    //creating a arraylist by taking the sports_club class
    private static List<Sports_Club> allfootballclubData = new ArrayList<>();
    private List<played_match> team_names = new ArrayList<>();

    //creating the addfootballclub method
    @Override
    public void addFootballClub(Sports_Club sports_club) {
        allfootballclubData.add(sports_club);
        System.out.println("Football club added successfully .............");
    }

    //creating the deletefootballclub method
    @Override
    public void deleteFootballClub(String Club_Name) {
        for (Sports_Club sports_club : allfootballclubData) {
            if (sports_club.getClub_Name().equals(Club_Name)) {                //If footballclub exsist in the list delete that club
                allfootballclubData.remove(sports_club);
                System.out.println("Foot ball club removed successfully");
                break;
            }
        }
    }

    //Creating the viewFootballClub method
    @Override
    public void viewFootballclub() {
        if (allfootballclubData.isEmpty()) {                      //If arraylsit is empty display an error message
            System.out.println("No Football club added");
        } else {
            System.out.println(allfootballclubData);           //else add the football club
        }
    }

    //creating the displaypremeireleaguetable and make it as descending order
    @Override
    public void displayPremeireLeagueTable(){
        if(allfootballclubData.isEmpty()){
            System.out.println("No Football Clubs Found ");
            return;
        }
        Collections.sort(allfootballclubData,Collections.reverseOrder());          //Sort the arraylist into reverse order
        for (Sports_Club sportsClub : allfootballclubData){
            System.out.println(sportsClub);
        }
    }

    //creating the team statistics to a selected club method
    @Override
    public void displayteamstatistics(String Club_Name){
        for (Sports_Club sports_club : allfootballclubData){
            if(sports_club.getClub_Name().equals(Club_Name)){                    //If arraylist name is equal then display all statistics to that club name
                System.out.println(sports_club);
                break;
            }
            else{
                System.out.println("Invalid name please enter a correct name !!!... ");
            }
        }
    }

    //Creating playedmatch method
    @Override
    public void Played_match(played_match Played_Match) throws IOException {
        for (Sports_Club sports_club : allfootballclubData) {
            footballclub Footballclub = (footballclub) sports_club;                  //Casting the football club class using sports club class
            int i = 1;
            if(Played_Match.getGoalscoredbyhometeam() > Played_Match.getGoalscoredbyawayteam()) {      //If home team goals more than away team goals then add statistics to that club
                if (sports_club.getClub_Name().equals(Played_Match.getHomeTeam())) {
                    Footballclub.setNo_of_points(Footballclub.getNo_of_points() + 2);
                    Footballclub.setWins(Footballclub.getWins() + i);
                }else{
                    Footballclub.setDefeats(Footballclub.getDefeats() + i);
                }
                //Get the common data to outside
                Footballclub.setGoals_scored(Footballclub.getGoals_scored() + Played_Match.getGoalscoredbyhometeam());
                Footballclub.setNo_of_goals_received(Footballclub.getNo_of_goals_received() + Played_Match.getGoalscoredbyawayteam());
                Footballclub.setNo_of_matches_played(Footballclub.getNo_of_matches_played() + 1);

                //display the winning team
                System.out.println(Played_Match.getHomeTeam() + " Won the match by " + (Played_Match.getGoalscoredbyhometeam() - Played_Match.getGoalscoredbyawayteam()) + " runs");

            }
            else if(Played_Match.getGoalscoredbyawayteam()>Played_Match.getGoalscoredbyhometeam()) {     //If away team goals more than home team then add statistics to that club
                if (sports_club.getClub_Name().equals(Played_Match.getAwayTeam())) {
                    Footballclub.setNo_of_points(Footballclub.getNo_of_points() + 2);
                    Footballclub.setWins(Footballclub.getWins() + i);
                }else{
                    Footballclub.setDefeats(Footballclub.getDefeats() + i);
                }
                //Get the common data to outside
                Footballclub.setGoals_scored(Footballclub.getGoals_scored() + Played_Match.getGoalscoredbyawayteam());
                Footballclub.setNo_of_goals_received(Footballclub.getNo_of_goals_received() + Played_Match.getGoalscoredbyhometeam());
                Footballclub.setNo_of_matches_played(Footballclub.getNo_of_matches_played() + 1);

                //display the winning team
                System.out.println(Played_Match.getAwayTeam() + " Won the match by " + (Played_Match.getGoalscoredbyawayteam() - Played_Match.getGoalscoredbyhometeam()) + " runs");

            }else if (Played_Match.getGoalscoredbyhometeam() == Played_Match.getGoalscoredbyawayteam()) {       //If goals are equal then add statistics to both classes
                if (sports_club.getClub_Name().equals(Played_Match.getAwayTeam())) {
                    Footballclub.setNo_of_points(Footballclub.getNo_of_points() + i);
                    Footballclub.setDraws(Footballclub.getDraws() + i);
                    Footballclub.setGoals_scored(Footballclub.getGoals_scored() + Played_Match.getGoalscoredbyhometeam());
                    Footballclub.setNo_of_goals_received(Footballclub.getNo_of_goals_received() + Played_Match.getGoalscoredbyawayteam());
                    Footballclub.setNo_of_matches_played(Footballclub.getNo_of_matches_played() + 1);
                    if(sports_club.getClub_Name().equals(Played_Match.getAwayTeam())){
                        Footballclub.setNo_of_points(Footballclub.getNo_of_points() + i);
                        Footballclub.setDraws(Footballclub.getDraws() + i);
                        Footballclub.setGoals_scored(Footballclub.getGoals_scored() + Played_Match.getGoalscoredbyawayteam());
                        Footballclub.setNo_of_goals_received(Footballclub.getNo_of_goals_received() + Played_Match.getGoalscoredbyhometeam());
                        Footballclub.setNo_of_matches_played(Footballclub.getNo_of_matches_played() + 1);
                    }
                }
                //disply the message
                System.out.println("Match Draw");
            }
            team_names.add(Played_Match);
            team_names = (List) team_names.stream().distinct().collect(Collectors.toList());       //Removing the duplicate data from the list
        }
        System.out.println(allfootballclubData);
        System.out.println(team_names);

        FileOutputStream file_output_stream = new FileOutputStream("matches.txt");                //Save the matches to a file
        ObjectOutputStream object_output_stream = new ObjectOutputStream(file_output_stream);

        for(played_match Playedmatch : team_names){
            object_output_stream.writeObject(Playedmatch);
        }

    }

    //Creating save method
    @Override
    public void savetofile(String filepath) throws IOException {
        FileOutputStream file_output_stream = new FileOutputStream(filepath);                    //Save the club names statistics and age into a file
        ObjectOutputStream object_output_stream = new ObjectOutputStream(file_output_stream);



        for(Sports_Club sports_club : allfootballclubData){
            object_output_stream.writeObject(sports_club);                                     //Write them in a file
        }
        System.out.println("Sport clubs have been saved to the file Successfully");           //Display a successful message
    }

    //Creating loadfile method
    @Override
    public void readfile(String filepath) throws IOException, ClassNotFoundException {
        for (;;) {                                                                           //creating a infinit for loop to travel through the file
            try {
                FileInputStream file_input_stream = new FileInputStream(filepath);
                ObjectInputStream object_input_stream = new ObjectInputStream(file_input_stream);       //read the file

                for (int a = 0; a < filepath.length(); a++) {
                    System.out.println(object_input_stream.readObject());                       //Print the file data in the console
                }
            }
            catch (EOFException e) {
                break;
            }
            System.out.println("!!!!...Sport clubs data have been loaded Successfully...!!!!");
            break;
        }
    }
}