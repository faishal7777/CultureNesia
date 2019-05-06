package com.runupstdio.culturenesia;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class BottomNavbarActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    SharedPreferences settings;
    private int direction = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);

        BottomNavigationView navigation = findViewById(R.id.bottom_nav);
        navigation.setOnNavigationItemSelectedListener(this);

        direction = getIntent().getIntExtra("direction", 1);

        if(direction==1)
            loadFragment(new BerandaFragment());
        else if(direction==2)
            loadFragment(new EnsiklopediFragment());
        else if(direction==3)
            loadFragment(new QuizFragment());
        else if(direction==4)
            loadFragment(new AkunFragment());
    }

    private boolean loadFragment (Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_beranda:
                setTheme(R.style.AppTheme);
                fragment = new BerandaFragment();
                break;

            case R.id.nav_ensiklopedi:
                setTheme(R.style.AppTheme);
                fragment = new EnsiklopediFragment();
                break;

            case R.id.nav_quiz:
                setTheme(R.style.AppTheme);
                fragment = new QuizFragment();
                break;

            case R.id.nav_akun:
                setTheme(R.style.AppTheme);
                fragment = new AkunFragment();
                break;
        }
        return loadFragment(fragment);
    }

}
