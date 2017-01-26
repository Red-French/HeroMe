package net.redfrench.herome.Activities;

import android.support.v7.app.AppCompatActivity;  // support library for older devices to use fragments
import android.os.Bundle;

import net.redfrench.herome.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
