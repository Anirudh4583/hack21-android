package com.bitaam.codeshop.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bitaam.codeshop.LoginActivity;
import com.bitaam.codeshop.R;
import com.bitaam.codeshop.databinding.FragmentDashboardBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    Button loginDashBtn;
    SharedPreferences sharedPreferences;
    FloatingActionButton addTemplateActionBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        loginDashBtn = root.findViewById(R.id.loginDashboardBtn);
        addTemplateActionBtn = root.findViewById(R.id.addTemplateActionBtn);

        onClickActivities();

        sharedPreferences = getActivity().getSharedPreferences("LoginToken", Context.MODE_PRIVATE);

        if (sharedPreferences.getString("LoginToken","No Response").equals("No Response")){
            loginDashBtn.setVisibility(View.VISIBLE);
            addTemplateActionBtn.setVisibility(View.GONE);
        }else{
            loginDashBtn.setVisibility(View.GONE);
            addTemplateActionBtn.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), "LoggedIn with token"+sharedPreferences.getString("LoginToken","No Response"), Toast.LENGTH_LONG).show();
        }

        return root;
    }

    private void onClickActivities() {

        loginDashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}