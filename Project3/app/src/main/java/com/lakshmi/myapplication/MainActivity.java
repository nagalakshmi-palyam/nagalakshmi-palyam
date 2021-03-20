package com.lakshmi.myapplication;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Button loadApi, postReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadApi = (Button) findViewById(R.id.loadApi);
        postReq = (Button) findViewById(R.id.postReq);

        loadApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getHttpResponse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    }

    public void getHttpResponse() throws IOException {

        String url = "https://cakeapi.trinitytuts.com/api/listuser";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

//        Response response = client.newCall(request).execute();
//        Log.e(TAG, response.body().string());

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                //call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String mMessage = response.body().string();
                Log.e("Lakshmi", mMessage);
            }
        });
    }


}