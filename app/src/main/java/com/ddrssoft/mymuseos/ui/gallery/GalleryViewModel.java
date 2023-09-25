package com.ddrssoft.mymuseos.ui.gallery;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddrssoft.mymuseos.modelo.Dialogo;
import com.ddrssoft.mymuseos.modelo.Museo;

import java.util.List;

public class GalleryViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData  mutable;
    public GalleryViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<List<Museo>> getListaMutable(){
        if(mutable==null){
            mutable=new MutableLiveData<>();
        }
        return mutable;
    }


}