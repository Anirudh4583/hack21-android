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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bitaam.codeshop.LoginActivity;
import com.bitaam.codeshop.R;
import com.bitaam.codeshop.adapters.HomeCodeAdapter;
import com.bitaam.codeshop.databinding.FragmentDashboardBinding;
import com.bitaam.codeshop.modals.CodeItemModal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    Button loginDashBtn;
    SharedPreferences sharedPreferences;
    FloatingActionButton addTemplateActionBtn;
    RecyclerView codeDashRecyclerView;
    String publicAddressesLoggedInUser;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        loginDashBtn = root.findViewById(R.id.loginDashboardBtn);
        addTemplateActionBtn = root.findViewById(R.id.addTemplateActionBtn);
        codeDashRecyclerView = root.findViewById(R.id.dashboardRecyclerView);
        codeDashRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        onClickActivities();

        sharedPreferences = getActivity().getSharedPreferences("LoginToken", Context.MODE_PRIVATE);

        if (sharedPreferences.getString("LoginToken","No Response").equals("No Response")){
            loginDashBtn.setVisibility(View.VISIBLE);
            addTemplateActionBtn.setVisibility(View.GONE);
        }else{
            loginDashBtn.setVisibility(View.GONE);
            addTemplateActionBtn.setVisibility(View.VISIBLE);
            publicAddressesLoggedInUser = "asd1234";
            setDataToRecyler();
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

    private void setDataToRecyler() {

        HomeCodeAdapter homeCodeAdapter1 = new HomeCodeAdapter(codeDashRecyclerView,getContext(),new ArrayList<CodeItemModal>());
        codeDashRecyclerView.setAdapter(homeCodeAdapter1);

        ArrayList<String> imgUrls = new ArrayList<>();
        imgUrls.add("https://cdn.dribbble.com/users/5682435/screenshots/14455889/media/babc675af388ef6419d4bfb03755e490.png");
        imgUrls.add("https://gdj-inr5u0ip5pewom.stackpathdns.com/wp-content/uploads/2017/03/002_web_design.jpg");
        imgUrls.add("https://miro.medium.com/max/1400/0*Y1whl5lAn-x3-D8s.png");
        imgUrls.add("https://cdn.dribbble.com/users/5682435/screenshots/14455889/media/babc675af388ef6419d4bfb03755e490.png");
        imgUrls.add("https://gdj-inr5u0ip5pewom.stackpathdns.com/wp-content/uploads/2017/03/002_web_design.jpg");
        imgUrls.add("https://miro.medium.com/max/1400/0*Y1whl5lAn-x3-D8s.png");
        imgUrls.add("https://cdn.dribbble.com/users/5682435/screenshots/14455889/media/babc675af388ef6419d4bfb03755e490.png");
        imgUrls.add("https://gdj-inr5u0ip5pewom.stackpathdns.com/wp-content/uploads/2017/03/002_web_design.jpg");
        imgUrls.add("https://miro.medium.com/max/1400/0*Y1whl5lAn-x3-D8s.png");
        imgUrls.add("https://cdn.dribbble.com/users/5682435/screenshots/14455889/media/babc675af388ef6419d4bfb03755e490.png");

        ArrayList<String> codeTitles = new ArrayList<>();
        codeTitles.add("This code provides you very pleasant sign in ui and saves your time.");
        codeTitles.add("Gallery implementing grid layout looks awesome and easy to use.");
        codeTitles.add("React dashboard UI with side bar navigation panel and search panel.");
        codeTitles.add("This code provides you very pleasant sign in ui and saves your time.");
        codeTitles.add("Gallery implementing grid layout looks awesome and easy to use.");
        codeTitles.add("React dashboard UI with side bar navigation panel and search panel.");
        codeTitles.add("This code provides you very pleasant sign in ui and saves your time.");
        codeTitles.add("Gallery implementing grid layout looks awesome and easy to use.");
        codeTitles.add("React dashboard UI with side bar navigation panel and search panel.");
        codeTitles.add("This code provides you very pleasant sign in ui and saves your time.");

        ArrayList<String> codeType = new ArrayList<>();
        codeType.add("Tradable");
        codeType.add("Open Source");
        codeType.add("Tradable");
        codeType.add("Tradable");
        codeType.add("Open Source");
        codeType.add("Tradable");
        codeType.add("Open Source");
        codeType.add("Tradable");
        codeType.add("Tradable");
        codeType.add("Open Source");

        ArrayList<String> publicAddresses = new ArrayList<>();
        publicAddresses.add("asd1234");
        publicAddresses.add("asd1234");
        publicAddresses.add("asd1234");
        publicAddresses.add("asd1234");
        publicAddresses.add("Open Source");
        publicAddresses.add("Tradable");
        publicAddresses.add("Open Source");
        publicAddresses.add("Tradable");
        publicAddresses.add("Tradable");
        publicAddresses.add("Open Source");

        String code = "import React, { Component } from \"react\";\n" +
                "\n" +
                "export default class Login extends Component {\n" +
                "    render() {\n" +
                "        return (\n" +
                "            <form>\n" +
                "                <h3>Sign In</h3>\n" +
                "\n" +
                "                <div className=\"form-group\">\n" +
                "                    <label>Email address</label>\n" +
                "                    <input type=\"email\" className=\"form-control\" placeholder=\"Enter email\" />\n" +
                "                </div>\n" +
                "\n" +
                "                <div className=\"form-group\">\n" +
                "                    <label>Password</label>\n" +
                "                    <input type=\"password\" className=\"form-control\" placeholder=\"Enter password\" />\n" +
                "                </div>\n" +
                "\n" +
                "                <div className=\"form-group\">\n" +
                "                    <div className=\"custom-control custom-checkbox\">\n" +
                "                        <input type=\"checkbox\" className=\"custom-control-input\" id=\"customCheck1\" />\n" +
                "                        <label className=\"custom-control-label\" htmlFor=\"customCheck1\">Remember me</label>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <button type=\"submit\" className=\"btn btn-primary btn-block\">Submit</button>\n" +
                "                <p className=\"forgot-password text-right\">\n" +
                "                    Forgot <a href=\"#\">password?</a>\n" +
                "                </p>\n" +
                "            </form>\n" +
                "        );\n" +
                "    }\n" +
                "}";

        for (int i=0;i<10;i++){

            CodeItemModal codeItemModal = new CodeItemModal();
            codeItemModal.setImgUrl(imgUrls.get(i));
            codeItemModal.setTitleText(codeTitles.get(i));
            codeItemModal.setAuthor("Mangalam Pandey");
            codeItemModal.setDate("12 ,Dec 2021 12:00");
            codeItemModal.setCode(code);
            codeItemModal.setType(codeType.get(i));
            codeItemModal.setPublicAddress(publicAddresses.get(i));

            if (publicAddressesLoggedInUser.equals(codeItemModal.getPublicAddress()))
            ((HomeCodeAdapter) Objects.requireNonNull(codeDashRecyclerView.getAdapter())).update(codeItemModal, "author");

        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}