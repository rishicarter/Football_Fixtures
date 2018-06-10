package Controllers;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.footballfixtures.rishi.footballfixtures.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.List;

import Adapters.worldCupFixtureAdapter;
import Model.worldCupFixtureModel;
import Response.worldCupFixtureResponse;
import cz.msebera.android.httpclient.Header;
import rest.APIClient;
import rest.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class worldCupFixtureFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String header_name = "X-Auth-Token";
    private static final String header_value = "8f2157cce11f426fb29924c6d7ce4e27";
    private final String timeFrame = "n6";

    private RecyclerView recyclerView;

    public worldCupFixtureFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
  /*  public static worldCupFixtureFragment newInstance(String param1, String param2) {
        worldCupFixtureFragment fragment = new worldCupFixtureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_world_cup_fixture, container, false);


        recyclerView = (RecyclerView)view.findViewById(R.id.fixture_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);;
        recyclerView.setLayoutManager(layoutManager);


        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<worldCupFixtureResponse> call = apiInterface.getFixtures(header_name,header_value,timeFrame);

        final ProgressDialog dialog;
        dialog = new ProgressDialog(getContext());
        dialog.setMax(100);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Loading....");
        dialog.show();

        call.enqueue(new Callback<worldCupFixtureResponse>() {

            @Override
            public void onResponse(Call<worldCupFixtureResponse> call, Response<worldCupFixtureResponse> response) {
                dialog.dismiss();
                Log.d("Response", "onResponse: "+String.valueOf(response));
                List<worldCupFixtureModel> worldCupFixtureModelList = response.body().getFixtures();
                recyclerView.setAdapter(new worldCupFixtureAdapter(worldCupFixtureModelList,getContext()));
                Toast.makeText(getContext(),"Successfull",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<worldCupFixtureResponse> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(getContext(),"Not Successfull - ",Toast.LENGTH_LONG).show();
                Log.d("Error","Eroor",t);
            }
        });

        return view;
    }

}
