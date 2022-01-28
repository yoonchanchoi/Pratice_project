package com.example.pratice_project;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private static String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static Retrofit_interface create(){
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Retrofit_interface.class);
    }
}
