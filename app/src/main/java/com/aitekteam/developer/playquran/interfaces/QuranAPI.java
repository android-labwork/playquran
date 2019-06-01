package com.aitekteam.developer.playquran.interfaces;

import com.aitekteam.developer.playquran.models.Chapters;
import com.aitekteam.developer.playquran.models.Verses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuranAPI {
    @GET("chapters")
    Call<Chapters> getChapters();

    @GET("verses?")
    Call<Verses> getVerses(
            @Query("recitation") int recitation,
            @Query("translations") int translations,
            @Query("language") String language,
            @Query("text_type") String text_type,
            @Query("page") int page
    );
}
