package com.footballfixtures.rishi.footballfixtures;

import android.support.v4.app.Fragment;

import Abstract.MainAbstract;
import Controllers.SingleCompetitionFragment;

/**
 * Created by rishi on 27/3/18.
 */

public class SingleCompetitionActivity extends MainAbstract {
    @Override
    protected Fragment createFragment() {
        return new SingleCompetitionFragment();
    }
}
