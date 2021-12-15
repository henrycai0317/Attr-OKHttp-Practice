package com.example.viewwithattrpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    //建立OKHttpClient
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    private List<PavilionArea> mPavilionAreas;
    private PavilionAreaAdapter mPavilionAreaAdapter;
    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //建立Request，設置動物園館資料連線
        Request request = new Request.Builder()
                .url("https://data.taipei/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
                .build();

        //建立Call
        Call call = client.newCall(request);
        //執行Call連線
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                //連線失敗
                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                //連線成功，從Response取得連線結果
                String result = response.body().string();
                Log.d(TAG, "onResponse: "+result);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        parseJSON(result);
                      mRecycler = findViewById(R.id.pavilion_area);
                      mRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                      mRecycler.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
                      mPavilionAreaAdapter = new PavilionAreaAdapter(MainActivity.this,mPavilionAreas);
                      mRecycler.setAdapter(mPavilionAreaAdapter);


                    }
                });
            }
        });




    }

    private void parseJSON(String json) {

        try {
            JSONObject jObject = new JSONObject(json);
            JSONArray jsonArray = jObject.getJSONObject("result").getJSONArray("results");

            for (int i = 0; i <jsonArray.length() ; i++) {
                Log.d(TAG, "result: "+jsonArray);
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String E_Pic_URL = jsonObject.getString("E_Pic_URL");
                String E_Geo = jsonObject.getString("E_Geo");
                String E_Info = jsonObject.getString("E_Info");
                String E_no = jsonObject.getString("E_no");
                String E_Category = jsonObject.getString("E_Category");
                String E_Name = jsonObject.getString("E_Name");
                String E_Memo = jsonObject.getString("E_Memo");
                String id = jsonObject.getString("_id");
                String E_URL = jsonObject.getString("E_URL");
                mPavilionAreas = new ArrayList<>();
                mPavilionAreas.add(new PavilionArea(E_Pic_URL,E_Geo,E_Info,E_no,E_Category,E_Name,E_Memo,id,E_URL));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}