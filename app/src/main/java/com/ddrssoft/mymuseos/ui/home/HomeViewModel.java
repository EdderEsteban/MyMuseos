package com.ddrssoft.mymuseos.ui.home;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddrssoft.mymuseos.modelo.Museo;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<List<Museo>> listaMutable;
    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<List<Museo>> getListaMutable(){
        if(listaMutable==null){
            listaMutable=new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void armarLista(){

        List<Museo> lista = new ArrayList<>();
        lista.add(new Museo("Muhsal","San Martín 611, San Luis", 02664452000,"09:00 - 20:00"));
        lista.add(new Museo("Museo Dora Ochoa de Masramón","Colón 508, San Luis", 02664452000,"09:00 - 20:00"));
        lista.add(new Museo("Museo Nativista Hector Aubert","Las Heras 150, Villa Mercedes", 257421368,"09:00 - 18:00"));
        lista.add(new Museo("Cabildo Historico","Ciudad de La Punta", 02664452000,"09:00 - 19:00"));
        lista.add(new Museo("Fundación Planetario de Merlo","Cta. La Granadilla 1000, Merlo", 02664770250,"19:30 - 22:00"));

        listaMutable.setValue(lista);
    }
}