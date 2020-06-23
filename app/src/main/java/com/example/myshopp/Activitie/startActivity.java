package com.example.myshopp.Activitie;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myshopp.Fragments.Login_fragment;
import com.example.myshopp.R;

import static com.example.myshopp.R.id.fragment_container;

public class startActivity extends AppCompatActivity {
    FrameLayout fragment_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //fragment_container=(FrameLayout)findViewById(R.id.fragment_container);
        Login_fragment lf=new Login_fragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container,lf);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
}
