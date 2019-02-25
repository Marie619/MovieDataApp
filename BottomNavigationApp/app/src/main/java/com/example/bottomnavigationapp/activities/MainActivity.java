package com.example.bottomnavigationapp.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bottomnavigationapp.R;
import com.example.bottomnavigationapp.fragments.CartFragment;
import com.example.bottomnavigationapp.fragments.GiftFragment;
import com.example.bottomnavigationapp.fragments.ProfileFragment;
import com.example.bottomnavigationapp.fragments.StoreFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav = findViewById(R.id.bottomNav);
        loadFragment(new StoreFragment());

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.navigation_shop: {
                        fragment = new StoreFragment();
                        loadFragment(fragment);
                        return true;
                    }
                    case R.id.navigation_gifts: {
                        fragment = new GiftFragment();
                        loadFragment(fragment);
                        return true;
                    }
                    case R.id.navigation_cart: {
                        fragment = new CartFragment();
                        loadFragment(fragment);
                        return true;
                    }
                    case R.id.navigation_profile: {
                        fragment = new ProfileFragment();
                        loadFragment(fragment);
                        return true;
                    }


                }
                return false;
            }
        });


    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
