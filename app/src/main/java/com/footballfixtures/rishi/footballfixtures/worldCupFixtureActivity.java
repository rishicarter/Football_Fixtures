package com.footballfixtures.rishi.footballfixtures;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import Abstract.MainAbstract;
import Controllers.worldCupFixtureFragment;

public class worldCupFixtureActivity extends MainAbstract {


    @Override
    protected Fragment createFragment() {

        String dateselected = (String)getIntent().getStringExtra(worldCupFixtureFragment.DATE_SELECT);
        Log.d("Acitivtydate", "createFragment: "+dateselected);
        return new worldCupFixtureFragment().newInstance(dateselected);
    }
}
