package com.example.sumi.youtubeparsing;

import com.example.sumi.youtubeparsing.entities.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Requestinterface {


    @GET("youtube/v3/playlistItems")
    Call<Example> getData(@Query("part") String part,
                         @Query("fields") String fields,
                         @Query("maxResults") String maxResults,
                         @Query("playlistId") String id,
                         @Query("key") String key);
}
