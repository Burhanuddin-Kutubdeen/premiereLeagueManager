import java.io.IOException;

public interface LeagueManager {

 void addClub();
 void deleteClub(String name);
 void displayStats(String name);
 void displayLeagueTable();
 void addMatch();
 void saveFile(String name,String fileName2) throws IOException;
 void loadFile(String fileName, String fileName2) throws IOException;
}
