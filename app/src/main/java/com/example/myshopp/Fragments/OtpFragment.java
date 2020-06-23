package com.example.myshopp.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myshopp.Activitie.Home_Activity;
import com.example.myshopp.R;


public class OtpFragment extends Fragment {

    EditText edt_otp1,edt_otp2,edt_otp3,edt_otp4,edt_otp5,edt_otp6;
    TextView txt_mobno;
    Button btn_verifiy;
    private TextWatcher tw;
    String mob_no_pass,otp_string,otp_text;
    ProgressDialog progressDialog;

    char[] otp_num;

    public OtpFragment() {
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
         View view=inflater.inflate(R.layout.fragment_otp_layout, container, false);
         progressDialog=new ProgressDialog(getActivity());
        Bundle extras = getArguments();
        mob_no_pass=extras.getString("mob_no_pass","");
        otp_string=extras.getString("otp","");
        otp_num = otp_string.toCharArray();
         edt_otp1=view.findViewById(R.id.edt_otp1);
         edt_otp2=view.findViewById(R.id.edt_otp2);
         edt_otp3=view.findViewById(R.id.edt_otp3);
         edt_otp4=view.findViewById(R.id.edt_otp4);
         edt_otp5=view.findViewById(R.id.edt_otp5);
         edt_otp6=view.findViewById(R.id.edt_otp6);

         btn_verifiy=view.findViewById(R.id.btn_verifiy);
         txt_mobno=view.findViewById(R.id.txt_mobno);

         txt_mobno.setText("+91"+mob_no_pass);


         edt_otp1.requestFocus();
         btn_verifiy.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 progressDialog.setMessage("please Wait.....");
                 progressDialog.show();
                 otp_text=edt_otp1.getText().toString()+edt_otp2.getText().toString()+edt_otp3.getText().toString()+edt_otp4.getText().toString()+edt_otp5.getText().toString()+edt_otp6.getText().toString();
                 if(otp_text.equals(otp_string))
                 {
                  progressDialog.dismiss();
                     /*Home_fragment lf=new Home_fragment();
                     FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                     transaction.replace(R.id.fragment_container,lf);
                     transaction.addToBackStack(null);
                     // Commit the transaction
                     transaction.commit();*/

                     Intent i=new Intent(getActivity(), Home_Activity.class);

                     startActivity(i);
                 }
             }
         });
         edt_otp1.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 if(charSequence.length()==1){
                     edt_otp2.requestFocus();
                 }

             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });
        edt_otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==1){
                    edt_otp3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==1){
                    edt_otp4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==1){
                    edt_otp5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_otp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==1){
                    edt_otp6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_otp6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==1){
                    edt_otp6.setFocusable(false);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }
}
