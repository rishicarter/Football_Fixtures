package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import Response.Result;
import UtilityClass.convertDateTime;

import com.footballfixtures.rishi.footballfixtures.R;

import java.text.ParseException;
import java.util.List;

import Model.worldCupFixtureModel;

/**
 * Created by rishi on 10/6/18.
 */

public class worldCupFixtureAdapter extends RecyclerView.Adapter<worldCupFixtureAdapter.ViewHolder> {
    private List<worldCupFixtureModel> worldCupFixtureModelList;
    private Context context;
    private int count=1;
    private String goalsHomeTeam = "-";
    private String goalsAwayTeam = "-";
    private String resultsTimedmatch = "    "+goalsHomeTeam+"   :   "+goalsAwayTeam;

    public worldCupFixtureAdapter(List<Model.worldCupFixtureModel> worldCupFixtureModel, Context context) {
        this.worldCupFixtureModelList = worldCupFixtureModel;
        this.context = context;
    }

    @Override
    public worldCupFixtureAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_worldcupfixturemodel,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(worldCupFixtureAdapter.ViewHolder holder, int position) {
        String[] datetime = null;
        String date=null,time=null;
        try {
            datetime = convertDateTime.convertDateTime(worldCupFixtureModelList.get(position).getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //date = datetime[0];
        time = datetime[1];
        Log.d("positions", "onBindViewHolder: "+position);
        setResultstonull();
        holder.matchnum.setText(String.valueOf(count++));
        holder.team1.setText(worldCupFixtureModelList.get(position).getHomeTeamName());
        holder.team2.setText(worldCupFixtureModelList.get(position).getAwayTeamName());
        holder.time.setText(time);
        holder.matchlive.setVisibility(View.INVISIBLE);
        if (worldCupFixtureModelList.get(position).getStatus().equals("TIMED")||worldCupFixtureModelList.get(position).getStatus().equals("SCHEDULED")) {
            holder.result.setText(resultsTimedmatch);
            //String.valueOf(worldCupFixtureModelList.get(position).getResult();
        }
        else {
            updateResults(position);
            holder.result.setText(resultsTimedmatch);
            if (worldCupFixtureModelList.get(position).getStatus().equals("IN_PLAY"))
                holder.matchlive.setVisibility(View.VISIBLE);
        }
    }

    private void setResultstonull() {
        goalsHomeTeam = "-";
        goalsAwayTeam = "-";
        resultsTimedmatch = "    "+goalsHomeTeam+"   :   "+goalsAwayTeam;
    }

    private void updateResults(int position) {
        goalsHomeTeam = String.valueOf(Math.floor((Double) worldCupFixtureModelList.get(position).getResult().getGoalsHomeTeam()));
        goalsAwayTeam = String.valueOf(Math.floor((Double) worldCupFixtureModelList.get(position).getResult().getGoalsAwayTeam()));
        goalsHomeTeam = goalsHomeTeam.replace(".0", "");
        goalsAwayTeam = goalsAwayTeam.replace(".0", "");
       // Toast.makeText(context, (CharSequence) worldCupFixtureModelList.get(position).getResult().getGoalsHomeTeam(),Toast.LENGTH_LONG).show();
        resultsTimedmatch = "    "+goalsHomeTeam+"   :   "+goalsAwayTeam;

    }

    @Override
    public int getItemCount() {
        return worldCupFixtureModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView team1,team2,time,result,matchlive,matchnum;
        private LinearLayout layoutTime, layoutResult;

        public ViewHolder(View itemView) {
            super(itemView);

            team1 = (TextView)itemView.findViewById(R.id.team1);
            team2 = (TextView)itemView.findViewById(R.id.team2);
            matchnum = (TextView)itemView.findViewById(R.id.matchnum);
            time = (TextView)itemView.findViewById(R.id.time);
            result = (TextView)itemView.findViewById(R.id.result);
            layoutResult = (LinearLayout)itemView.findViewById(R.id.layoutResult);
            layoutTime = (LinearLayout)itemView.findViewById(R.id.layoutTime);
            matchlive = (TextView)itemView.findViewById(R.id.matchlive);
            //matchlive.setEnabled(false);
            //setlayoutEnabled(layoutResult,false);
            //date.setText(worldCupFixtureModelList.get(0).getDate());
        }
    }
    // ans = hide or show
    /*private void setlayoutEnabled(View layout, boolean ans) {
        layout.setEnabled(ans);
        if (layout instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) layout;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setlayoutEnabled(child, ans);
            }
        }
    }*/
}
