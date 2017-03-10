package net.redfrench.herome.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;  // so the app can use fragments
import android.support.v4.app.FragmentManager;  // using the support library, so using the FragmentManager that's in AppCompatActivity
import android.support.v7.app.AppCompatActivity;  // support library for older devices to use fragments
import android.os.Bundle;

import net.redfrench.herome.Fragments.BackstoryFragment;
import net.redfrench.herome.Fragments.ChoosePowerFragment;
import net.redfrench.herome.Fragments.MainFragment;
import net.redfrench.herome.R;


// implement all fragments
public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, ChoosePowerFragment.ChoosePowerInteractionListener, BackstoryFragment.BackstoryFragmentInteractionListener {

    public String BACKSTORYHDR;
    public String BACKSTORY;
    public String USERSPOWER;
    public String HOWOBTAINED;
    public String WEAKNESS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ~ LOAD A FRAGMENT (load the first fragment this way, because you need the container) ~
        // get the FragmentManger
        FragmentManager manager = getSupportFragmentManager();  // Like the Activity Manager at the OS level manages activities,
                                                                // the FragmentManager manages fragments, but inside of the app
        // get the FrameLayout where the fragment will go
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);  // id of FrameLayout in the main activity

        if (fragment == null) {  // if the fragment has previously loaded, it will be in memory. Otherwise, fragment will be null.
            fragment = new MainFragment();  // MainFragment inherits from Fragment (see MainFragment.java)
            manager.beginTransaction()  // anytime you work with the FragmentManager, you begin a transaction
                    .add(R.id.fragment_container, fragment)  // add puts the fragment on the screen
                    .commit();  // you always end it by committing
        }
    }

    public void loadChoosePowerScreen() {
        // ~ LOAD A FRAGMENT (can load subsequent fragments like this since container exists upon loading of first fragment) ~
        ChoosePowerFragment choosePowerFragment = new ChoosePowerFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, choosePowerFragment)  // put choosePowerFragment on the screen
                .addToBackStack(null)  // will remember transaction after commit, and operation will be reversed when later popped off stack
                                       // cmd-click 'addToBackStack' and you'll see it takes a parameter, but you don't have to give it a name if you don't want to reference it
                                       // * Unlike activities, fragments are only placed on the backstack if explicitly requested.
                .commit();
    }

    public void loadBackstoryScreen() {
        BackstoryFragment backstoryFragment = new BackstoryFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, backstoryFragment)
                .addToBackStack(null)
                .commit();
    }

    public void loadMainScreen() {
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, mainFragment)
                .addToBackStack(null)
                .commit();
    }

    // implement fragments
    @Override
    public void onMainFragmentInteraction(Uri uri) {}
    @Override
    public void onChoosePowerFragmentInteraction(Uri uri) {}
    @Override
    public void onBackstoryFragmentInteraction(Uri uri) {}
}
