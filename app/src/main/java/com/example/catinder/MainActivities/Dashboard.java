package com.example.catinder.MainActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.catinder.R;
import com.example.catinder.UIElements.FragmentAll;
import com.example.catinder.Util.FragmentAllListener;
import com.example.catinder.UIElements.FragmentLiked;
import com.example.catinder.UIElements.FragmentTrending;
import com.example.catinder.Util.CatProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements FragmentAllListener {

    private ArrayList<CatProfile> loved = new ArrayList<CatProfile>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragmentAll(loved)).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected = new FragmentAll(loved);
                switch (item.getItemId()){
                    case R.id.nav_all:
                        selected = new FragmentAll(loved);
                        break;
                    case R.id.nav_liked:
                        selected = new FragmentLiked(loved);
                        break;
                    case R.id.nav_trending:
                        selected = new FragmentTrending();
                        break;
                }

                System.out.println("fragment now ::: " + selected);

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selected).commit();
                return true;
            }
        });


    }

    @Override
    public void onCommunicate(ArrayList<CatProfile> loved) {

        this.loved = loved;
        System.out.println("::::::::::::::::::::LOVED sized:::::::::::::::::::::::::::: " + loved.size());

    }
}
