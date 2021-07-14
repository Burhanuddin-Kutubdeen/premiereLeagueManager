import java.util.Comparator;

public class WinComparator implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        return club1.getWinCount() - club2.getWinCount();
    }
}
