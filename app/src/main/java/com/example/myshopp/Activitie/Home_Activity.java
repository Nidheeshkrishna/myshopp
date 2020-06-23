package com.example.myshopp.Activitie;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.myshopp.Adapters.SliderAdapter;
import com.example.myshopp.DataModels.Datum;
import com.example.myshopp.Fragments.Home_fragment;
import com.example.myshopp.NetWork.Api;
import com.example.myshopp.NetWork.Apiclient;
import com.example.myshopp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_Activity extends AppCompatActivity {
    private ActionBar toolbar;
    ViewPager viewPager;

    TabLayout indicator;
    private Api apiInterface;
    Fragment fragment;
    List<Datum> Slider_images;
    List<String> Slider_images_list;
    SliderAdapter sliderAdapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);


        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Home");
        fragment = new Home_fragment();
        loadFragment(fragment);


    }

    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.page_1:
                    toolbar.setTitle("Home");
                    fragment = new Home_fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.page_2:
                    toolbar.setTitle("Category");
                    return true;
                case R.id.page_3:
                    toolbar.setTitle("Search");
                    return true;

            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        String backStateName = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_Home, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }


}