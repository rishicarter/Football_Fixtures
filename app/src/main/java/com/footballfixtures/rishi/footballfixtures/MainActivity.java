package com.footballfixtures.rishi.footballfixtures;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Abstract.MainAbstract;
import Controllers.MainFragment;

public class MainActivity extends MainAbstract {


    @Override
    protected Fragment createFragment() {
        //todo : add fragment
        return new MainFragment();
    }
}
