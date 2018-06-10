package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.footballfixtures.rishi.footballfixtures.R;

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
        holder.team1.setText(worldCupFixtureModelList.get(position).getHomeTeamName());
        holder.team2.setText(worldCupFixtureModelList.get(position).getAwayTeamName());
        holder.time.setText(worldCupFixtureModelList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return worldCupFixtureModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView team1,team2,time;

        public ViewHolder(View itemView) {
            super(itemView);

            team1 = (TextView)itemView.findViewById(R.id.team1);
            team2 = (TextView)itemView.findViewById(R.id.team2);
            time = (TextView)itemView.findViewById(R.id.time);

        }
    }
}
