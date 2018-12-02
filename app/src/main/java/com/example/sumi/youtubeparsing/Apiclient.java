package com.example.sumi.youtubeparsing;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
    private  static
    final String BASE_URL="https://www.googleapis.com/";
 private static Retrofit retrofit;
 public static  Retrofit getclient(){
     retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
     return  retrofit;
 }
}
