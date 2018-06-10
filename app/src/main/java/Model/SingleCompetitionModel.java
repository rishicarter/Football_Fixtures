package Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rishi on 27/3/18.
 */

public class SingleCompetitionModel {

    private static final String caption_name = "caption";
    private static final String currMatchday = "currentMatchday";
    private static final String totMatchdays = "numberOfMatchdays";
    private static final String totgames = "numberOfGames";
    private static final String totteams = "numberOfTeams";

    private String caption;
    private int curr_matchday, total_matchday, total_teams, total_games;


    public SingleCompetitionModel fromJSON(JSONObject response) {

        SingleCompetitionModel model = new SingleCompetitionModel();

        try {
            model.caption = response.getString(caption_name);
            model.curr_matchday = response.getInt(currMatchday);
            model.total_matchday = response.getInt(totMatchdays);
            model.total_games = response.getInt(totgames);
            model.total_teams = response.getInt(totteams);
            return  model;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getCaption() {
        return caption;
    }

    public int getCurr_matchday() {
        return curr_matchday;
    }

    public int getTotal_matchday() {
        return total_matchday;
    }

    public int getTotal_teams() {
        return total_teams;
    }

    public int getTotal_games() {
        return total_games;
    }
}
