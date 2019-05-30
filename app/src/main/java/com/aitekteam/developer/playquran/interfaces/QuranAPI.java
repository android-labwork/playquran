package com.aitekteam.developer.playquran.interfaces;

import com.aitekteam.developer.playquran.models.Chapters;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuranAPI {
    @GET("chapters")
    Call<Chapters> getChapters();
}
