import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GUI extends Application {



    private static List footballclubes = new ArrayList();       //Creating an arraylist
    private List  match_Played = new ArrayList();               // Creating an arraylist
    private List random_match_list = new ArrayList();           //Creating an arraylist

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        matchArray();
        frontend("Data.txt");                            //Load the file
    }

    public void matchArray()throws IOException, ClassNotFoundException{
        for (; ; ) {                                           //Creating an infinty loop
            try {
                FileInputStream file_input_stream = new FileInputStream("matches.txt");
                ObjectInputStream object_input_stream = new ObjectInputStream(file_input_stream);

                for (int j = 0; j < 10; j++) {
                    random_match_list.add(object_input_stream.readObject());             //Reading the file

                }
            } catch (EOFException e) {
                break;
            }
            break;
        }
    }

    public void frontend(String filepath) throws IOException, ClassNotFoundException {
        for (; ; ) {                                           //Creating an infinty loop
            try {
                FileInputStream file_input_stream = new FileInputStream(filepath);
                ObjectInputStream object_input_stream = new ObjectInputStream(file_input_stream);

                for (int j = 0; j < 10; j++) {
                    footballclubes.add(object_input_stream.readObject());             //Reading the file

                }
            } catch (EOFException e) {
                break;
            }
            break;
        }

        Stage primaryStage = new Stage();                                       //Creating a pane and stage
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #262626");

        Label header = new Label("Premire League Season 2020-21");               //Creating a label to display topic
        header.setPrefWidth(1240);
        header.setPrefHeight(50);
        header.setStyle("-fx-background-color: #3F1052 ");                      //Adding a background color
        header.setTextFill(Color.web("white", 0.8));
        header.setFont(new Font("arial,sans-serif", 24));                      //Change the font color and style


        TableView premeireLeagueTable = new TableView();// Creating a table view
        premeireLeagueTable.setLayoutY(50);
        premeireLeagueTable.setLayoutX(100);

        TableColumn club_name = new TableColumn(" Club Name ");                 //Adding columns to the table
        club_name.setMinWidth(150);
        club_name.setSortable(false);                                        //Setting the auto sort disable

        TableColumn club_location = new TableColumn(" Club Location ");
        club_location.setMinWidth(150);
        club_location.setSortable(false);

        TableColumn points = new TableColumn(" Points ");
        points.setMinWidth(100);
        points.setSortable(false);

        TableColumn matches_played = new TableColumn(" No: of matches ");
        matches_played.setMinWidth(100);
        matches_played.setSortable(false);

        TableColumn wins = new TableColumn(" Wins ");
        wins.setMinWidth(100);
        wins.setSortable(false);

        TableColumn defeats = new TableColumn(" Defeats ");
        defeats.setMinWidth(100);
        defeats.setSortable(false);

        TableColumn draws = new TableColumn(" Draws ");
        draws.setMinWidth(100);
        draws.setSortable(false);

        TableColumn goal_scored = new TableColumn(" Goal Scored ");
        goal_scored.setMinWidth(100);
        goal_scored.setSortable(false);

        TableColumn goal_receive = new TableColumn(" Goal Received ");
        goal_receive.setMinWidth(100);
        goal_receive.setSortable(false);

        Button sort_goal = new Button();                                   //Creating a button
        sort_goal.setText("Goal Scored");                                  // Set text to the button
        sort_goal.setLayoutY(500);
        sort_goal.setLayoutX(180);
        sort_goal.setPrefWidth(150);
        sort_goal.setPrefHeight(40);
        sort_goal.setStyle("-fx-background-color: #4CAF50 ");            //Add style to the button

        Button sort_wins = new Button();                                 //Creating a button
        sort_wins.setText("Sort to Wins");                               //Set text to the button
        sort_wins.setLayoutY(500);
        sort_wins.setLayoutX(350);
        sort_wins.setPrefWidth(140);
        sort_wins.setPrefHeight(40);
        sort_wins.setStyle("-fx-background-color: #4CAF50 ");           //add style to the button

        Button random_match = new Button();                             //Creating a button
        random_match.setText("Played Match");                           //Set text to the button
        random_match.setLayoutX(500);
        random_match.setLayoutY(500);
        random_match.setPrefWidth(140);
        random_match.setPrefHeight(40);
        random_match.setStyle("-fx-background-color: #4CAF50 ");       //Add style to the button

        Button show_matches = new Button();                           //Add style to the button
        show_matches.setText("Show Played Match List");               //Set text to the button
        show_matches.setLayoutX(650);
        show_matches.setLayoutY(500);
        show_matches.setPrefWidth(180);
        show_matches.setPrefHeight(40);
        show_matches.setStyle("-fx-background-color: #4CAF50 ");       //Add style to the button

        System.out.println(footballclubes);                          //Printing the main arraylist
        System.out.println(random_match_list);

        for (int i = 0; i < footballclubes.size(); i++) {          //Creating a for loop size of the main list

            footballclub FootballClub = (footballclub) footballclubes.get(i);             //The process of converting value of one data type to another data type

            club_name.setCellValueFactory(new PropertyValueFactory<>("Club_Name"));
            club_location.setCellValueFactory(new PropertyValueFactory<>("Location"));
            points.setCellValueFactory(new PropertyValueFactory<>("no_of_points"));
            matches_played.setCellValueFactory(new PropertyValueFactory<>("no_of_matches_played"));         //Adding values to the rows in the table
            wins.setCellValueFactory(new PropertyValueFactory<>("wins"));
            defeats.setCellValueFactory(new PropertyValueFactory<>("defeats"));
            draws.setCellValueFactory(new PropertyValueFactory<>("draws"));
            goal_scored.setCellValueFactory(new PropertyValueFactory<>("goals_scored"));
            goal_receive.setCellValueFactory(new PropertyValueFactory<>("no_of_goals_received"));

            premeireLeagueTable.getItems().add(FootballClub);

        }

        sort_goal.setOnAction(new EventHandler<ActionEvent>() {                              //Adding a set on action to sort the goals
            @Override
            public void handle(ActionEvent event) {
                goal_scored.setSortable(true);
                premeireLeagueTable.getSortOrder().add(goal_scored);
                goal_scored.setSortType(TableColumn.SortType.DESCENDING);
                goal_scored.setSortable(false);
            }
        });

        sort_wins.setOnAction(new EventHandler<ActionEvent>() {                         //Adding a set on action to sort the wins
            @Override
            public void handle(ActionEvent event) {
                wins.setSortable(true);
                premeireLeagueTable.getSortOrder().add(wins);
                wins.setSortType(TableColumn.SortType.DESCENDING);
                wins.setSortable(false);
            }
        });

        random_match.setOnAction(new EventHandler<ActionEvent>() {                    //Adding a set on action to randomly genarated match
            @Override
            public void handle(ActionEvent event) {
                played_match Playedmatch = null;
                for (int i = 0; i < footballclubes.size(); i++) {

                    footballclub Footballclub = (footballclub) footballclubes.get(i);      //Casting the footballclub

                    match_Played.add(Footballclub.getClub_Name());                        //Adding club names to the arraylist
                    match_Played = (List) match_Played.stream().distinct().collect(Collectors.toList());        //Removing the duplicate values
                }

                Random generate = new Random();
                int team_one = generate.nextInt(footballclubes.size());             //Generate random numbers
                int team_two = generate.nextInt(footballclubes.size());

                footballclub Footballclub = (footballclub) footballclubes.get(team_one);

                Object home_team_name = match_Played.get(team_one);              //Taking the random genarated name from the arraylist
                Object away_team_name = match_Played.get(team_two);


                if (!away_team_name.equals(home_team_name)) {

                    int goal_scoredHomeTeam = generate.nextInt(8);       //Generate random goals for the home team and away team
                    int goal_scoredAwayTeam = generate.nextInt(8);


                    int day = generate.nextInt(30);
                    int month = generate.nextInt(12);

                    SheduledDate sheduledDate = new SheduledDate(day, month);
                    //Adding data to the played match class
                    Playedmatch = new played_match(String.valueOf(home_team_name), String.valueOf(away_team_name), sheduledDate, goal_scoredHomeTeam, goal_scoredAwayTeam);

                    random_match_list.add(Playedmatch);

                    //Setting all the values and update the table
                    Footballclub.setNo_of_matches_played(Footballclub.getNo_of_matches_played() + 1);
                    if (goal_scoredHomeTeam > goal_scoredAwayTeam) {
                        if (Playedmatch.getHomeTeam().equals(Footballclub.getClub_Name())) {
                            Footballclub.setNo_of_points(Footballclub.getNo_of_points() + 2);
                            Footballclub.setWins(Footballclub.getWins() + 1);
                            Footballclub.setGoals_scored(Footballclub.getGoals_scored() + Playedmatch.getGoalscoredbyhometeam());
                            Footballclub.setNo_of_goals_received(Footballclub.getNo_of_goals_received() + Playedmatch.getGoalscoredbyawayteam());
                        }if(!Playedmatch.getAwayTeam().equals(Footballclub.getClub_Name())){
                            Footballclub.setDefeats(Footballclub.getDefeats() + 1);
                            Footballclub.setGoals_scored(Footballclub.getGoals_scored() + Playedmatch.getGoalscoredbyhometeam());
                            Footballclub.setNo_of_goals_received(Footballclub.getNo_of_goals_received() + Playedmatch.getGoalscoredbyawayteam());
                        }
                    } else if(goal_scoredAwayTeam > goal_scoredHomeTeam){
                        if (Playedmatch.getAwayTeam().equals(Footballclub.getClub_Name())) {
                            Footballclub.setNo_of_points(Footballclub.getNo_of_points() + 2);
                            Footballclub.setWins(Footballclub.getWins() + 1);
                            Footballclub.setGoals_scored(Footballclub.getGoals_scored() + Playedmatch.getGoalscoredbyawayteam());
                            Footballclub.setNo_of_goals_received(Footballclub.getNo_of_goals_received() + Playedmatch.getGoalscoredbyhometeam());
                        }if(Playedmatch.getHomeTeam().equals(Footballclub.getClub_Name())){
                            Footballclub.setDefeats(Footballclub.getDefeats() + 1);
                            Footballclub.setGoals_scored(Footballclub.getGoals_scored() + Playedmatch.getGoalscoredbyhometeam());
                            Footballclub.setNo_of_goals_received(Footballclub.getNo_of_goals_received() + Playedmatch.getGoalscoredbyawayteam());
                        }
                    }
                    if (Playedmatch.getGoalscoredbyhometeam() == Playedmatch.getGoalscoredbyawayteam()) {
                        Footballclub.setDraws(Footballclub.getDraws() + 1);
                        Footballclub.setNo_of_points(Footballclub.getNo_of_points() + 1);
                        Footballclub.setGoals_scored(Footballclub.getGoals_scored() + goal_scoredHomeTeam);
                        Footballclub.setNo_of_goals_received(Footballclub.getNo_of_goals_received() + goal_scoredAwayTeam);
                    }



                    System.out.println("Home Team: " + Playedmatch.getHomeTeam());
                    System.out.println("Goal Scored by Home Team: " + Playedmatch.getGoalscoredbyhometeam());
                    System.out.println("Away Team: " + Playedmatch.getAwayTeam());
                    System.out.println("Goal Scored by Away Team: " + Playedmatch.getGoalscoredbyawayteam());
                }

                premeireLeagueTable.refresh();      //Table updating
                System.out.println(footballclubes);

            }
        });

        TableView <played_match> matchTable = new TableView();                           //Creating a table and adding columns
        matchTable.setLayoutX(100);
        matchTable.setLayoutY(600);

        TableColumn home_team = new TableColumn("Home_Team");                           //Add columns to the tableview
        home_team.setMinWidth(150);
        home_team.setSortable(false);                                                   //Disable the sort function in table view

        TableColumn away_team = new TableColumn(" Away_Team");
        away_team.setMinWidth(150);
        away_team.setSortable(false);

        TableColumn goal_s = new TableColumn("Goal_Scored_by_Home_Team");
        goal_s.setMinWidth(100);
        goal_s.setSortable(false);

        TableColumn goal_r = new TableColumn("Goal_Scored_by_Away_Team");
        goal_r.setMinWidth(100);
        goal_r.setSortable(false);

        TableColumn<played_match, Number> date = new TableColumn("Date");
        date.setMinWidth(100);
        date.setSortable(false);

        TableColumn<played_match, Number> month = new TableColumn("Month");
        date.setMinWidth(100);
        date.setSortable(false);

        TextField tf = new TextField("Enter Date to Search");                             //Creating a textfield to search
        tf.setLayoutX(900);
        tf.setLayoutY(600);

        Button search = new Button("Find");                                            //Creating a button and add text to that button
        search.setLayoutX(890);
        search.setLayoutY(635);
        search.setPrefWidth(100);
        search.setPrefHeight(40);
        search.setStyle("-fx-background-color: #4CAF50 ");                            //Add styles to the button

        Button cancelSearch = new Button("Cancel");                                   //Creating a button and set the text to that button
        cancelSearch.setLayoutX(1010);
        cancelSearch.setLayoutY(635);
        cancelSearch.setPrefWidth(100);
        cancelSearch.setPrefHeight(40);
        cancelSearch.setStyle("-fx-background-color: #4CAF50 ");                     //Add styles to that button

        show_matches.setOnAction(new EventHandler<ActionEvent>() {                //Showing the played matches with the date
            @Override
            public void handle(ActionEvent event) {
                matchTable.getItems().clear();                                      //Removing the table column values

                for (int i = 0; i < random_match_list.size(); i++) {              //Creating a for loop to read the arraylist
                    if (!random_match_list.isEmpty()) {
                        played_match PlayedMatch = (played_match) random_match_list.get(i);     //Cast the played_match class using an arraylist

                        home_team.setCellValueFactory(new PropertyValueFactory<>("HomeTeam"));       //Add values to the table column
                        away_team.setCellValueFactory(new PropertyValueFactory<>("AwayTeam"));
                        goal_s.setCellValueFactory(new PropertyValueFactory<>("goalscoredbyhometeam"));
                        goal_r.setCellValueFactory(new PropertyValueFactory<>("goalscoredbyawayteam"));
                        date.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getMatchdate().getDay())); new PropertyValueFactory<>("day");
                        month.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getMatchdate().getMonth())); new PropertyValueFactory<>("month");

                        System.out.println(PlayedMatch);

                        date.setSortable(true);
                        matchTable.getSortOrder().add(date);
                        date.setSortType(TableColumn.SortType.ASCENDING);                          //Sorting function
                        date.setSortable(false);

                        month.setSortable(true);
                        matchTable.getSortOrder().add(month);
                        month.setSortType(TableColumn.SortType.ASCENDING);
                        month.setSortable(false);

                        matchTable.getItems().addAll(PlayedMatch);

                    }else{
                        System.out.println("No matches played");
                    }
                }

                System.out.println(random_match_list);
            }
        });

        ObservableList observableList = matchTable.getItems();                                                     //Creating an observable list
        FilteredList<played_match> filteredData = new FilteredList<played_match>(observableList, param -> {       //Filter the played_match class data using observable list
            return true;
        });

        search.setOnAction(new EventHandler<ActionEvent>() {                                                      //On button action
            @Override
            public void handle(ActionEvent event) {

                // Set the filter Predicate when the filter is changes.
                tf.textProperty().addListener((observable, value1, value2) -> {                                 //get the  textfieled value and search according to that value
                    filteredData.setPredicate(myObject -> {
                        // If textbox value is empty, display all matches.
                        if (value2 == null || value2.isEmpty()) {
                            return true;
                        }

                        // Compare date field in object with filter.
                        String data = value2.toLowerCase();                                                 //get the value as lower case value

                        if (String.valueOf(myObject.getMatchdate().getDay()).contains(data)) {            //Searching it
                            return true;
                        }
                        return false; // If its not match.
                    });
                    matchTable.setItems(filteredData);
                });

                // Add data to the table

            }
        });

        cancelSearch.setOnAction(new EventHandler<ActionEvent>() {                              //cancelSearch onclick disable the text feild
            @Override
            public void handle(ActionEvent event) {
                tf.setDisable(true);
            }
        });


        matchTable.getColumns().addAll(home_team, goal_s, away_team, goal_r, date,month);           //add the column to the table

        pane.getChildren().add(matchTable);                                                        //add the table to the pane


        pane.getChildren().add(search);                  //add button to the pane
        pane.getChildren().add(cancelSearch);           //add button to the pane
        pane.getChildren().add(tf);                    //add textfeild to the pane
        pane.getChildren().add(random_match);         //add button to the pane
        pane.getChildren().add(sort_goal);            //add button to the pane
        pane.getChildren().add(sort_wins);           //add button to the pane
        pane.getChildren().add(show_matches);       //add button to the pane
        pane.getChildren().add(header);             //add label to the pane


        premeireLeagueTable.getColumns().addAll(club_name, club_location,matches_played,points,wins,defeats,draws,goal_scored, goal_receive);       //add columns to the tableview
        pane.getChildren().add(premeireLeagueTable);                   //add tableview to the pane

        Scene scene = new Scene(pane, 1240, 1024);                  //creating the scene
        primaryStage.setScene(scene);                              //Set the primary stage
        primaryStage.setTitle("Premier League 2021");              //Set the title
        primaryStage.showAndWait();                              //Show and wait
    }
}