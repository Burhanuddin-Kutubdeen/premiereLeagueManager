import java.util.Comparator;

class PointsComparer implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1,FootballClub club2){
        if (club1.getClubPoints()> club2.getClubPoints())
            return -1;
        else
            if (club1.getClubPoints()< club2.getClubPoints())   // arranging clubs in Descending order according to  points
            return 1;
            else {
                int goalDifference1 = club1.getGoalsScoredCount()-club2.getGoalsReceivedCount();
                int goalDifference2 = club2.getGoalsScoredCount()-club2.getGoalsReceivedCount();
                if(goalDifference1>goalDifference2)
                    return -1; //goal difference
                else if (goalDifference1<goalDifference2)
                    return 1;
                else return 0;

            }

    }

}
