package com.example.myshopp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myshopp.R;


public class Registeration_fragment extends Fragment {

    EditText edt_name, edt_phone, edt_password, edt_cpassword;
    Button btn_signup;
    String name, phone, password, cpassword;

    public Registeration_fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registeration_layout, container, false);
        edt_name = view.findViewById(R.id.edt_rname);
        edt_phone = view.findViewById(R.id.edt_rphone);
        edt_password = view.findViewById(R.id.edt_rpassword);
        edt_cpassword = view.findViewById(R.id.edt_cpassword);
        btn_signup = view.findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edt_name.getText().toString();
                phone = edt_phone.getText().toString();
                password = edt_password.getText().toString();
                if (phone.isEmpty() || phone != null) {
                    if (password.isEmpty() || password != null) {
                        if (password.equals(edt_cpassword.getText().toString())) {
                            Registeration_Method(name, phone);
                        } else {
                            edt_cpassword.setError("Please enter same password");
                        }


                    } else {
                        edt_password.setError("Please Enter Password No");
                    }
                } else {
                    edt_phone.setError("Please enter Mobile No");

                }
            }

        });

        return view;
    }

    public void Registeration_Method(String name, String phone) {


    }
}
