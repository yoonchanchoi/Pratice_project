package com.example.pratice_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MainAdapter mainAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rc_1);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        Retrofit_interface retrofit_interface = Retrofit.create();
        retrofit_interface.getList()
                .enqueue(new Callback<List<MainData>>() {
                    @Override
                    public void onResponse(Call<List<MainData>> call, Response<List<MainData>> response) {
                        mainAdapter = new MainAdapter(response.body());                                     //response => 응답에 대한 정보 즉 우리가 원하는 정보
                        recyclerView.setAdapter(mainAdapter);                                               //body => 정보부분 , header가 인증 관련 부분!
                        Log.d("테스트", response.toString());
                        Log.d("테스트", response.body().toString());
                        Log.d("테스트", response.headers().toString());
                    }

                    @Override
                    public void onFailure(Call<List<MainData>> call, Throwable t) {

                    }
                });

    }
}