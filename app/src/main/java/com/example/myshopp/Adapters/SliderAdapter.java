package com.example.myshopp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.myshopp.DataModels.Datum;
import com.example.myshopp.Fragments.Home_fragment;
import com.example.myshopp.R;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private List<Datum> image_slides;
    private List<String> colorName;
    private ViewGroup currentView;
    private LayoutInflater inflater;
    private Object Picasso;

    public SliderAdapter(Context context, List<Datum> image_slides) {
        this.context =  context;

        this.image_slides = image_slides;
    }

    @Override
    public int getCount() {
        return image_slides.size();
    }

    @Override



    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_slider, null);
        ImageView imageView = view.findViewById(R.id.img_slider);
        //imageView.setImageResource(Integer.parseInt(image_slides.get(position).getImages()));
        //imageView.setImageDrawable(context.getResources().getDrawable(getImageAt(position)));

        //Picasso.
        //Picasso.get().load("image_URL").into(imageView);
        //Picasso.with().load("https://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png").into(imageView);
        Glide.with(context)
                .load(image_slides.get(position).getImages())
                .into(imageView);
        collection.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
