package com.bitaam.codeshop.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bitaam.codeshop.R;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }
    Button logoutBtn;
    TextView userTokenTv;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        logoutBtn = view.findViewById(R.id.logoutBtn);
        userTokenTv = view.findViewById(R.id.userTokenTv);

        sharedPreferences = getActivity().getSharedPreferences("LoginToken", Context.MODE_PRIVATE);

        if (sharedPreferences.getString("LoginToken","No Response").equals("No Response")){
            logoutBtn.setText("No user logged in");
            logoutBtn.setEnabled(false);
        }else{
            userTokenTv.setVisibility(View.VISIBLE);
            userTokenTv.setText("Logged in user token\n"+sharedPreferences.getString("LoginToken","No Response"));
            logoutBtn.setText("Logout");
            logoutBtn.setEnabled(true);
        }

        onClickActivities();

        return view;
    }

    private void onClickActivities() {

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("LoginToken","No Response");
                editor.putString("PublicAddress","No Response");
                editor.apply();
                Toast.makeText(getContext(), "Current user logged out", Toast.LENGTH_SHORT).show();
                logoutBtn.setText("No user logged in");
                logoutBtn.setEnabled(false);
                userTokenTv.setVisibility(View.GONE);
            }
        });

    }
}