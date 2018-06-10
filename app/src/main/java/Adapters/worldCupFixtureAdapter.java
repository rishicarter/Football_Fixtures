package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
        date = datetime[0];
        time = datetime[1];
        holder.team1.setText(worldCupFixtureModelList.get(position).getHomeTeamName());
        holder.team2.setText(worldCupFixtureModelList.get(position).getAwayTeamName());
        holder.date.setText(date);
        holder.time.setText(time);
    }

    @Override
    public int getItemCount() {
        return worldCupFixtureModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView team1,team2,time,date;

        public ViewHolder(View itemView) {
            super(itemView);

            team1 = (TextView)itemView.findViewById(R.id.team1);
            team2 = (TextView)itemView.findViewById(R.id.team2);
            date = (TextView)itemView.findViewById(R.id.date);
            time = (TextView)itemView.findViewById(R.id.time);

        }
    }
}
