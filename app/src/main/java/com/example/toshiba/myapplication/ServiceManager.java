package com.example.toshiba.myapplication;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

public class ServiceManager {

    private Context mContext;
    private static  ServiceManager instance = new ServiceManager();

    private ServiceManager() {}

    public static ServiceManager getInstance(Context context) {
        if(instance.mContext == null) {
            instance.mContext = context;
            AndroidNetworking.initialize(context);

        }
        return instance;
    }

    public void login(String username, String password, JSONObjectRequestListener listener) {
        AndroidNetworking.get("https://rsaliciaservice.herokuapp.com/recomendaciones/1980")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener);
    }
}
