package Controllers;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.footballfixtures.rishi.footballfixtures.R;
import com.footballfixtures.rishi.footballfixtures.worldCupFixtureActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    CalendarView calendarView;
    FloatingActionButton floatingActionButton;
    public static final String datePattern = "yyyy-MM-dd";

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        floatingActionButton = (FloatingActionButton)view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
            }
        });
        calendarView = (CalendarView)view.findViewById(R.id.worldCupCalender);
        calendarView.setFocusedMonthDateColor(Color.RED);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayofmonth) {
                //Toast.makeText(getContext(),year + "/0" + (month+1) + "/" + dayofmonth, Toast.LENGTH_LONG).show();
                String dateselectedwoformat = String.valueOf(year)+"-"+String.valueOf(month+1)+"-"+String.valueOf(dayofmonth);
                SimpleDateFormat format = new SimpleDateFormat(datePattern);
                String dateselected = null;
                try {
                    Date date = format.parse(dateselectedwoformat);
                    Log.d("date", "onSelectedDayChange: "+date);
                    dateselected = format.format(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Log.d("mainfrag - date", "onSelectedDayChange: "+dateselected);
                Intent intent = new Intent(getActivity(),worldCupFixtureActivity.class);
                intent.putExtra(worldCupFixtureFragment.DATE_SELECT,dateselected);
                startActivity(intent);
            }
        });

        return view;
    }

    private void createDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("World Cup Fixures! 2018");
        alertDialog.setMessage("Click a a date to know the Fixtures!");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


}
