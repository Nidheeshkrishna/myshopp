package com.example.myshopp.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myshopp.Activitie.Home_Activity;
import com.example.myshopp.Adapters.SliderAdapter;
import com.example.myshopp.DataModels.Datum;
import com.example.myshopp.NetWork.Api;
import com.example.myshopp.NetWork.Apiclient;
import com.example.myshopp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.AbstractCollection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home_fragment extends Fragment {


    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager viewPager;
    private TabLayout indicator;
    private SliderAdapter sliderAdapter;
    private List<Datum> Slider_images;
    private Api apiInterface;

    //int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;
    public Home_fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home_layout, container, false);
        // Inflate the layout for this fragment
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        indicator = (TabLayout) view.findViewById(R.id.indicator);



        GetImages();

        //Timer timer = new Timer();
       // timer.scheduleAtFixedRate(new Home_fragment.SliderTimer(), 2000, 100);
        return view;
    }



    private void runOnUiThread(Runnable runnable) {

    }
    public class SliderTimer extends TimerTask {

        @Override
        public void run() {
            Home_fragment.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //if(Slider_images.size()>0) {
                        if (viewPager.getCurrentItem() < Slider_images.size()- 1) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    //}
                }
            });
        }
    }
    public void GetImages() {
        apiInterface = Apiclient.getClient().create(Api.class);
        Call<Datum> call = apiInterface.get_slider_images();
        call.enqueue(new Callback<Datum>() {
            String path;
            @Override
            public void onResponse(Call<Datum> call, Response<Datum> response) {
                if (response.isSuccessful()) {
                    Datum datum = response.body();
                    Slider_images =response.body().getData();

                    //for (int i = 0; i < response.body().getData().size(); i++) {
                    //Slider_images_list.add(response.body().getImages());
                    //}

                    //Slider_images= new ArrayList<>();
                    //Slider_images= (List<Datum>) response.body();
                    //Slider_images_list.add(datum.getImages());
                    //Toast.makeText(Home_Activity.this, "" + Slider_images.get(0).getImages(), Toast.LENGTH_SHORT).show();
                    // viewPager=findViewById(R.id.viewPager);*******
                    //sliderAdapter=new SliderAdapter()
                    sliderAdapter = (new SliderAdapter(getActivity(), Slider_images));
                    viewPager.setAdapter(sliderAdapter);
                    indicator.setupWithViewPager(viewPager, true);
                    final Handler handler = new Handler();
                    final Runnable Update = new Runnable() {
                        public void run() {
                            if (currentPage == NUM_PAGES-1) {
                                currentPage = 0;
                            }
                            viewPager.setCurrentItem(currentPage++, true);
                        }
                    };

                    timer = new Timer(); // This will create a new Thread
                    timer.schedule(new TimerTask() { // task to be scheduled
                        @Override
                        public void run() {
                            handler.post(Update);
                        }
                    }, DELAY_MS, PERIOD_MS);
                    //Slider_images_list.add(path);




                }
            }

            @Override
            public void onFailure(Call<Datum> call, Throwable t) {

            }


        });

    }
}

