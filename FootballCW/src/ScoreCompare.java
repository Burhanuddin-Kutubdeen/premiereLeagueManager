import java.util.Comparator;

public class ScoreCompare implements Comparator<FootballClub> {


    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        return club1.getGoalsScoredCount() - club2.getGoalsScoredCount();
    }
}
