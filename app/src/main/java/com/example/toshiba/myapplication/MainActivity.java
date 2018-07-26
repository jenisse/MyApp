package com.example.toshiba.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServiceManager
                .getInstance(getApplicationContext())
                .login("sapazad@pucp.edu.pe", "0123456789", new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        User userResponse = User.jsonToObject(response);
//                        System.out.print(userResponse);
                        System.out.println(response.toString());
                        try {
                            generatelist(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
                    }
                });
    }

    public void generatelist(JSONObject response) throws JSONException {
        String title;
        String titulo_alicia;
        double similarity;
        String link;
        List<Recommendation> recomendaciones = new ArrayList<>();
        JSONArray list=response.getJSONArray("recommendations");
        System.out.println(list.toString());
        for(int i=0; i<list.length(); i++){
            title=list.getJSONObject(i).getString("title");
            titulo_alicia=list.getJSONObject(i).getString("titulo_alicia");
            link=list.getJSONObject(i).getString("url");
            similarity=list.getJSONObject(i).getDouble("similarity_percentage");
            Recommendation rec=new Recommendation();
            rec.setTitle(title);
            rec.setLink(link);
            rec.setSimilarity_percentage(similarity);
            rec.setTitulo_alicia(titulo_alicia);
            recomendaciones.add(rec);
            System.out.println(title);
            System.out.println(titulo_alicia);
            System.out.println(link);
            System.out.println(similarity);
        }


    }
}
