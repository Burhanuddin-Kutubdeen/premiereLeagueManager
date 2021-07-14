import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable {

    private int winCount;
    private int drawCount;
    private int defeatCount;
    private int goalsScoredCount;
    private int goalsReceivedCount;
    private int clubPoints;
    private int matchesPlayed;

    public FootballClub (String clubName,String clubLocation)
    {
        super(clubName,clubLocation);

    }


    @Override
    public String toString() {
        return "FootballClub{" + super.toString() +
                "\n winCount = " + winCount +
                "\n drawCount = " + drawCount +
                "\n defeatCount = " + defeatCount +
                "\n goalsScoredCount = " + goalsScoredCount +
                "\n goalsReceivedCount = " + goalsReceivedCount +
                "\n points = " + clubPoints +
                "\n matchesPlayed = " + matchesPlayed +
                '}';
    }

    public int getWinCount() {
        return winCount;
    }

    public int getDrawCount(){
        return drawCount;
    }

    public int getDefeatCount() {
        return defeatCount;
    }

    public int getGoalsScoredCount() {
        return goalsScoredCount;
    }

    public int getGoalsReceivedCount() {
        return goalsReceivedCount;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getClubPoints() {
        return clubPoints;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }

    public void setDefeatCount(int defeatCount) {
        this.defeatCount = defeatCount;
    }

    public void setGoalsScoredCount(int goalsScoredCount) {
        this.goalsScoredCount = goalsScoredCount;
    }

    public void setGoalsReceivedCount(int goalsReceivedCount) {
        this.goalsReceivedCount = goalsReceivedCount;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setClubPoints(int clubPoints) {
        this.clubPoints = clubPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),winCount,drawCount,defeatCount,goalsScoredCount,goalsReceivedCount, clubPoints,matchesPlayed);
    }
}
