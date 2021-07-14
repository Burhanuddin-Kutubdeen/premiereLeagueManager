import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PremierLeagueManager implements LeagueManager{
      List<FootballClub> league = new ArrayList<>();
      List<Match> matchesPlayed = new ArrayList<>();
      private static final int MAX_COUNT = 20;
      private int clubOpenings = 20;


    public void saveFile(String fileName1,String fileName2) throws IOException {
        //writing Object to file

        FileOutputStream fos1 = new FileOutputStream(fileName1);
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);

        for (FootballClub club:league){
            oos1.writeObject(club);
        }

        oos1.flush();
        oos1.close();
        fos1.close();

        FileOutputStream fos2 = new FileOutputStream(fileName2);
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);

        for (Match match: matchesPlayed){
            oos2.writeObject(match);
        }

        oos2.flush();
        oos2.close();
        fos2.close();
        System.out.println("saved to file");

    }

    @Override
    public void loadFile(String fileName1, String fileName2) throws IOException {
        FileInputStream fis1 = new FileInputStream(fileName1);
        ObjectInputStream ois1 = new ObjectInputStream(fis1);

        for(;;) {
            try {
                FootballClub club = (FootballClub) ois1.readObject();
                league.add(club);
            }
            catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }

        fis1.close();
        ois1.close();

        FileInputStream fis2 = new FileInputStream(fileName2);
        ObjectInputStream ois2 = new ObjectInputStream(fis2);

        for(;;) {
            try {
                Match match = (Match) ois2.readObject();
                matchesPlayed.add(match);
            }
            catch (EOFException | ClassNotFoundException e) {

                break;
            }
        }

        fis2.close();
        ois2.close();

        System.out.println("Data is Loaded from File");
    }
    @Override
    public void addClub() {

        if(league.size() == clubOpenings) {
            System.out.println("League is already Full!");
            return;
        }

        Scanner sc =new Scanner(System.in);

        System.out.println("Enter Team Name : ");
        String name = sc.nextLine();

        for(FootballClub club: league) {
            if(name.equals(club.getClubName())) {
                System.out.printf("Club %s already exists\n",name);
                return;

            }
        }
        System.out.println("Enter Team Location :  ");
        String location = sc.nextLine();

        FootballClub club = new FootballClub(name,location);

        league.add(club);
        System.out.printf("%s was added to Premier League Successfully!\n", club.getClubName());
    }

    @Override
    public void deleteClub(String name) {
        boolean clubExists = false;
        for (SportsClub club: league) {
            if(club.getClubName().equals(name)) {//checking if the club already exists
                league.remove(club);
                clubExists = true;
                System.out.printf("%s was removed Successfully!\n", club.getClubName());
                break;
            }
        }
        if (!clubExists) {
            System.out.printf("Club with %s is not found in the League\n", name);//to avoid printing it many times
        }
    }
    //to display stats of a club
    @Override
    public void displayStats(String name) {

        boolean clubExists = false;
        for (FootballClub club : league) {
            if(club.getClubName().equals(name)){
                clubExists = true;
                System.out.println("Club " + club.getClubName()+" statistics : ");
                System.out.println("  Matches Won    : " +club.getWinCount());
                System.out.println("  Matches Tied   : " +club.getDrawCount());
                System.out.println("  Matches Lost   : " +club.getDefeatCount());
                System.out.println("  Scored Goals   : " +club.getGoalsScoredCount());
                System.out.println("  Received Goals : " +club.getGoalsReceivedCount());
                System.out.println("  Points         : " +club.getClubPoints());
                System.out.println("  Matches Played : " +club.getMatchesPlayed());
                break;
            }
        }
        if (!clubExists) {
            System.out.printf("Club with %s is not available\n", name);
        }
    }

    @Override
    public void displayLeagueTable(){
        if (league.isEmpty()){
            System.out.println("Premier League Table is empty");
            return;
        }
        Collections.sort(league, new PointsComparer());
        for (FootballClub club: league) {
            System.out.println("FootballClub name  = " + club.getClubName() +
                    ", location = " + club.getClubLocation() +
                    ", win=" + club.getWinCount() +
                    ", draw=" + club.getDrawCount() +
                    ", defeat=" + club.getDefeatCount() +
                    ", scoredGoal=" + club.getMatchesPlayed() +
                    ", point=" + club.getClubPoints() +
                    '}');
        }
    }

    @Override
    public void addMatch() {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter date (format yyyy-mm-dd): ");
        String matchDate;
        Date date = null;
        while (true) {
            matchDate = sc.nextLine();

            try {//validating the date if its a text or thr wrong dateformat
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date = simpleDateFormat.parse(matchDate);
                if (matchDate.equals(simpleDateFormat.format(date))) {
                    break;
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format,enter date in this format(yyyy-mm-dd): ");

            }
        }

        System.out.println("Enter Home Team : ");
        String homeName = sc.nextLine();
        FootballClub homeClubName = null;

        boolean home = false;
        for (FootballClub club : league) {
            if (club.getClubName().equals(homeName)) {
                homeClubName = club;
                home = true;
                break;
            }
        }
        if (!home) {
            System.out.printf("Club with %s is not available\n", homeName);//to avoid printing it many times
            return;
        }

        System.out.println("Enter team B");
        String awayName = sc.nextLine();
        FootballClub awayClubName = null;

        boolean away = false;
        for (FootballClub club : league) {
            if (club.getClubName().equals(awayName)) {
                awayClubName = club;
                away = true;
                break;
            }
        }
        if (!away) {
            System.out.printf("Club with %s is not available\n", awayName);
            return;
        }

        int homeScore = 0;

        while (true) {
            System.out.printf("Enter %s goal score : ", homeClubName.getClubName());
            String line = sc.nextLine();

            try {
                homeScore = Integer.parseInt(line);
                if (homeScore > 0) {
                    break;
                }
                else{
                    System.out.println("enter a positive number only");
                }
            } catch (Exception e) {
                System.out.println("Enter a number!");
            }

        }


        int awayScore = 0;

        while (true) {
            System.out.printf("Enter %s goal score : ", awayClubName.getClubName());
            String line = sc.nextLine();

            try {
                awayScore = Integer.parseInt(line);
                if (awayScore > 0) {
                    break;
                }
                else{
                    System.out.println("enter a positive number only");
                }
            } catch (Exception e) {
                System.out.println("Enter a number!");
            }
        }


        Match match = new Match(homeClubName,awayClubName,homeScore,awayScore,matchDate);
        matchesPlayed.add(match);
        homeClubName.setGoalsScoredCount(homeClubName.getGoalsScoredCount()+homeScore);
        awayClubName.setGoalsScoredCount(awayClubName.getGoalsScoredCount()+awayScore);
        homeClubName.setGoalsReceivedCount(homeClubName.getGoalsReceivedCount()+awayScore);
        awayClubName.setGoalsReceivedCount(awayClubName.getGoalsReceivedCount()+homeScore);
        homeClubName.setMatchesPlayed(homeClubName.getMatchesPlayed()+1);
        awayClubName.setMatchesPlayed(awayClubName.getMatchesPlayed()+1);

        if (match.getHomeScore() > match.getAwayScore()){
            homeClubName.setWinCount(homeClubName.getWinCount()+1);
            awayClubName.setDefeatCount(awayClubName.getDefeatCount()+1);
            homeClubName.setClubPoints(homeClubName.getClubPoints()+3);

        }
        else if (match.getHomeScore() < match.getAwayScore()){
            awayClubName.setWinCount(awayClubName.getWinCount()+1);
            awayClubName.setClubPoints(awayClubName.getClubPoints()+3);
            homeClubName.setDefeatCount(homeClubName.getDefeatCount()+1);
        }
        else {
            homeClubName.setDrawCount(homeClubName.getDrawCount()+1);
            awayClubName.setDrawCount(awayClubName.getDrawCount()+1);
            homeClubName.setClubPoints(homeClubName.getClubPoints()+1);
            awayClubName.setClubPoints(awayClubName.getClubPoints()+1);
        }
        System.out.println("Match was succesfully added");

    }

}



