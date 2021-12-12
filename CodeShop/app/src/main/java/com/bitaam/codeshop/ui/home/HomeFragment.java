package com.bitaam.codeshop.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bitaam.codeshop.R;
import com.bitaam.codeshop.adapters.HomeCodeAdapter;
import com.bitaam.codeshop.databinding.FragmentHomeBinding;
import com.bitaam.codeshop.modals.CodeItemModal;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    RecyclerView codeHomeRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        codeHomeRecyclerView = root.findViewById(R.id.homeRecyclerView);
        codeHomeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        setDataToRecyler();


        return root;
    }

    private void setDataToRecyler() {

        HomeCodeAdapter homeCodeAdapter = new HomeCodeAdapter(codeHomeRecyclerView,getContext(),new ArrayList<CodeItemModal>());
        codeHomeRecyclerView.setAdapter(homeCodeAdapter);

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

        for (int i=0;i<10;i++){

            CodeItemModal codeItemModal = new CodeItemModal();
            codeItemModal.setImgUrl(imgUrls.get(i));
            codeItemModal.setTitleText(codeTitles.get(i));
            codeItemModal.setAuthor("Mangalam Pandey");
            codeItemModal.setDate("12 ,Dec 2021 12:00");

            ((HomeCodeAdapter) Objects.requireNonNull(codeHomeRecyclerView.getAdapter())).update(codeItemModal, "author");

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}