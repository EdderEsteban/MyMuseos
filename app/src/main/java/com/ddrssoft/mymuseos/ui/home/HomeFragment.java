package com.ddrssoft.mymuseos.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ddrssoft.mymuseos.databinding.FragmentHomeBinding;
import com.ddrssoft.mymuseos.modelo.Museo;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Pasar la lista
        homeViewModel.getListaMutable().observe(getViewLifecycleOwner(), new Observer<List<Museo>>() {
            @Override
            public void onChanged(List<Museo> farmacias) {
                RecyclerView rv = binding.rvMuseos;
                GridLayoutManager glm = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
                rv.setLayoutManager(glm);
                MuseoAdapter iad = new MuseoAdapter(farmacias,getContext(),getLayoutInflater());
                rv.setAdapter(iad);
            }
        });
        homeViewModel.armarLista();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}