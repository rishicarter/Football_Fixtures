package Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rishi on 10/6/18.
 */

public class Links_ {

    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("competition")
    @Expose
    private Competition_ competition;
    @SerializedName("homeTeam")
    @Expose
    private HomeTeam homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private AwayTeam awayTeam;

    public Self_ getSelf() {
        return self;
    }

    public void setSelf(Self_ self) {
        this.self = self;
    }

    public Competition_ getCompetition() {
        return competition;
    }

    public void setCompetition(Competition_ competition) {
        this.competition = competition;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }
}
