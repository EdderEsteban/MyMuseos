package com.ddrssoft.mymuseos.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.ddrssoft.mymuseos.R;
import com.ddrssoft.mymuseos.modelo.Museo;

import java.util.List;

public class MuseoAdapter extends RecyclerView.Adapter<MuseoAdapter.ViewHolder> {
    private List<Museo> museo;
    private Context context;
    private LayoutInflater li;

    public MuseoAdapter(List<Museo> museo, Context context, LayoutInflater li) {
        this.museo = museo;
        this.context = context;
        this.li = li;
    }


    @NonNull
    @Override
    public MuseoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item_museo,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseoAdapter.ViewHolder holder, int position) {
        holder.nombre.setText("Nombre: " + museo.get(position).getNombre());
        holder.direccion.setText("Dirección: " + museo.get(position).getDireccion());
    }

    @Override
    public int getItemCount() {
        return museo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView direccion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            direccion = itemView.findViewById(R.id.tvDireccion);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("museo", museo.get(getAdapterPosition()));
                    Navigation.findNavController(view).navigate(R.id.nav_detalle, bundle);

                }
            });
        }
    }
}
