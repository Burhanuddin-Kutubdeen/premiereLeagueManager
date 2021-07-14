import java.io.Serializable;

public class Match implements Serializable {
    private FootballClub homeTeam;
    private FootballClub awayTeam;
    private int homeScore;
    private int awayScore;
    private String date;

    public Match(FootballClub homeTeam, FootballClub awayTeam, int homeScore, int awayScore, String date) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamA=" + homeTeam.getClubName() +
                ", teamB=" + awayTeam.getClubName() +
                ", teamAScore=" + homeScore +
                ", teamBScore=" + awayScore +
                ", date=" + date +
                '}';
    }

    public FootballClub getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(FootballClub homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FootballClub getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(FootballClub awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}


