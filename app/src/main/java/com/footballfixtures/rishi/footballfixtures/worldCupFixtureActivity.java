package com.footballfixtures.rishi.footballfixtures;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Abstract.MainAbstract;
import Controllers.worldCupFixtureFragment;

public class worldCupFixtureActivity extends MainAbstract {


    @Override
    protected Fragment createFragment() {
        return new worldCupFixtureFragment();
    }
}
