package Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import Model.worldCupFixtureModel;

/**
 * Created by rishi on 9/6/18.
 */

public class worldCupFixtureResponse {

    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("fixtures")
    @Expose
    private List<worldCupFixtureModel> fixtures = null;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public List<worldCupFixtureModel> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<worldCupFixtureModel> fixtures) {
        this.fixtures = fixtures;
    }
}
