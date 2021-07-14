import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {

    private String clubName;
    private String clubLocation;

    public SportsClub(String clubName, String clubLocation) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    @Override
    public String toString() {
        return "clubName='" + clubName + '\'' +
                ", clubLocation='" + clubLocation + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub sportsClub = (SportsClub) o;
        return Objects.equals(clubName,sportsClub.clubName) &&
                Objects.equals(clubLocation,sportsClub.clubLocation);
    }


    @Override
    public int hashCode() {
        return Objects.hash(clubName, clubLocation);
    }

    public String getClubName() {
        return clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubLocation(String clubLocation){
        this.clubLocation = clubLocation;
    }




}
