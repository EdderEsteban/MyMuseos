package com.ddrssoft.mymuseos.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddrssoft.mymuseos.R;
import com.ddrssoft.mymuseos.databinding.FragmentDetalleBinding;
import com.ddrssoft.mymuseos.modelo.Museo;


public class Detalle extends Fragment {
    private FragmentDetalleBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Recuperar los datos del Museo del Bundle
        Bundle bundle = getArguments();
        Museo museo = (Museo) bundle.getSerializable("museo");

        binding.tvName.setText(museo.getNombre());
        binding.tvTelefono.setText("Teléfono: " + museo.getTelefono());
        binding.tvHorario.setText("Horario: " + museo.getHorario());

        return root;
    }
}