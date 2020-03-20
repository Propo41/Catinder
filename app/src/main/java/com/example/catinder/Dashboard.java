package com.example.catinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.catinder.main_fragments.FragmentAll;
import com.example.catinder.main_fragments.FragmentLiked;
import com.example.catinder.main_fragments.FragmentTrending;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragmentAll()).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected = new FragmentAll();
                switch (item.getItemId()){
                    case R.id.nav_all:
                        selected = new FragmentAll();
                        break;
                    case R.id.nav_liked:
                        selected = new FragmentLiked();
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
}
