package com.example.pratice_project;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Retrofit_interface {
    @GET("/posts")
    Call<List<MainData>>getList();

}
