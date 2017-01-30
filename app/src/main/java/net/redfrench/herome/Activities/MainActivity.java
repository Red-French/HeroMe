package net.redfrench.herome.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;  // so the app can use fragments
import android.support.v4.app.FragmentManager;  // using the support library, so using the FragmentManager that's in AppCompatActivity
import android.support.v7.app.AppCompatActivity;  // support library for older devices to use fragments
import android.os.Bundle;

import net.redfrench.herome.Fragments.MainFragment;
import net.redfrench.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the FragmentManger
        FragmentManager manager = getSupportFragmentManager();  // Like the Activity Manager at the OS level manages activities,
                                                                // the FragmentManager manages fragments, but inside of the app
        // get the FrameLayout where the fragment will go
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);  // id of FrameLayout in the main activity

        if (fragment == null) {  // if the fragment has previously loaded, it wilol be in memory. Otherwise, fragment will be null.
            fragment = new MainFragment();  // MainFragment inherits from Fragment (see MainFragment.java)
            manager.beginTransaction()  // anytime you work with the FragmentManager, you begin a transaction
                    .add(R.id.fragment_container, fragment).commit();  // and you always end it by committing
                    // add puts the fragment on the screen
        }
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }
}
