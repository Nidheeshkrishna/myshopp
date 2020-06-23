package com.example.myshopp.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myshopp.Activitie.Home_Activity;
import com.example.myshopp.DataModels.LogiData;
import com.example.myshopp.DataModels.Regidata;
import com.example.myshopp.NetWork.Api;
import com.example.myshopp.NetWork.Apiclient;
import com.example.myshopp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_fragment extends Fragment {
    Button btn_login,btn_newuser,btn_forgot,btn_otp;
    EditText edt_mobno,edt_password;
    String unname;
    private Api apiInterface;
ProgressDialog progressDialog;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login_page, container, false);
        progressDialog=new ProgressDialog(getActivity());
        edt_mobno=view.findViewById(R.id.edt_uname);
        edt_password=view.findViewById(R.id.edt_password);
        btn_login=view.findViewById(R.id.btn_login);
        btn_newuser=view.findViewById(R.id.btn_newuser);
        btn_otp=view.findViewById(R.id.btn_otp);
btn_newuser.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Registeration_fragment lf=new Registeration_fragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container,lf);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();



        //Intent i=new Intent(getActivity(), Home_Activity.class);

        //startActivity(i);



    }
});
btn_otp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        unname=edt_mobno.getText().toString();
        if (!unname.isEmpty() || unname != null) {
            if(unname.length()==10)
            {
                progressDialog.setMessage("Please Wait....");
                progressDialog.show();
Login_withpassword(unname);
            }
            else
            {
                edt_mobno.setError("Please Enter  Valid Mobile No");
            }

        }  else
        {
            edt_mobno.setError("Please Enter Mobile No");
        }
    }



});

        return view;
    }
    private void Login_withpassword(final String uname) {
        apiInterface = Apiclient.getClient().create(Api.class);
        Call<Regidata> call = apiInterface.registeration(uname);
        call.enqueue(new Callback<Regidata>() {
            @Override
            public void onResponse(Call<Regidata> call, Response<Regidata> response) {
                if (response.isSuccessful()) {
                    Regidata data=response.body();
                    if(data.getStatus().equals("true"))
                    {
                        Bundle mob_no_pass = new Bundle();
                        mob_no_pass.putString("mob_no_pass",uname);
                        mob_no_pass.putString("otp",data.getOtp());
                        progressDialog.dismiss();
                        OtpFragment lf=new OtpFragment();
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        // Replace whatever is in the fragment_container view with this fragment,
                        // and add the transaction to the back stack so the user can navigate back
                        transaction.replace(R.id.fragment_container,lf);
                        transaction.addToBackStack(null);
                        // Commit the transaction
                        lf.setArguments(mob_no_pass);
                        transaction.commit();
                        Toast.makeText(getActivity(),""+data.getOtp(), Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onFailure(Call<Regidata> call, Throwable t) {

            }
        });

    }
}
