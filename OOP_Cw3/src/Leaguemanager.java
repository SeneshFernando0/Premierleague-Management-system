import java.io.IOException;

//creating the interface as leaguemanager interface
public interface Leaguemanager {
    //creating methods
    void addFootballClub(Sports_Club sportsClub);
    void deleteFootballClub(String Club_Name);
    void viewFootballclub();
    void displayPremeireLeagueTable();
    void displayteamstatistics(String Club_Name);
    void Played_match(played_match Played_Match) throws IOException;
    void savetofile(String filepath) throws IOException;
    void readfile(String filepath) throws IOException, ClassNotFoundException;
}
