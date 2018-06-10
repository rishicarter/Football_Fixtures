package Abstract;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.footballfixtures.rishi.footballfixtures.R;

/**
 * Created by rishi on 26/3/18.
 */

public abstract class MainAbstract extends FragmentActivity {


    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment==null){

            fragment = createFragment();
            manager.beginTransaction()
                    .add(R.id.fragmentContainer,fragment)
                    .commit();
        }

    }
}
