package Controllers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.footballfixtures.rishi.footballfixtures.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import Model.SingleCompetitionModel;
import cz.msebera.android.httpclient.Header;

/**
 * Created by rishi on 27/3/18.
 */

public class SingleCompetitionFragment extends Fragment{



    SingleCompetitionModel model;
    private String competition_id = "445";
    private static final String tag = "SGF";

    // Default competition id -> premiere league
    public SingleCompetitionFragment() {
    }

    final String FF_Url = "http://api.football-data.org/v1/competitions/"+competition_id;
    // Header valules
    private static String header_name = "X-Auth-Token";
    private static String header_value = "8a0295cd84214f079645cd5b6a5471da";

    TextView caption,curr_matchday, total_matchday, total_teams, total_games;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Intitialize model
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.single_competition_fragment,container,false);
        caption = (TextView)view.findViewById(R.id.caption);
        curr_matchday = (TextView) view.findViewById(R.id.curr_matchday);
        total_matchday = (TextView) view.findViewById(R.id.total_matchday);
        total_teams = (TextView) view.findViewById(R.id.total_teams);
        total_games = (TextView) view.findViewById(R.id.total_games);

        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader(header_name,header_value);
        client.get(FF_Url, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(getActivity(),"Request Success",Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity(),String.valueOf(response),Toast.LENGTH_LONG).show();
//                Log.i(tag,String.valueOf(response));
                SingleCompetitionModel model = new SingleCompetitionModel().fromJSON(response);
                updateUI(model);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getActivity(),"Request Failed",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void updateUI(SingleCompetitionModel model) {
        caption.setText(model.getCaption());
        curr_matchday.setText(String.valueOf(model.getCurr_matchday()));
        total_matchday.setText(String.valueOf(model.getTotal_matchday()));
        total_teams.setText(String.valueOf(model.getTotal_teams()));
        total_games.setText(String.valueOf(model.getTotal_games()));
    }
}
