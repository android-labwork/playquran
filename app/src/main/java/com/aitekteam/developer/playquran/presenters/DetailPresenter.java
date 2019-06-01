package com.aitekteam.developer.playquran.presenters;

import android.content.Context;

import com.aitekteam.developer.playquran.R;
import com.aitekteam.developer.playquran.data.Chapter;
import com.aitekteam.developer.playquran.interfaces.LoaderHelper;
import com.aitekteam.developer.playquran.interfaces.QuranAPI;
import com.aitekteam.developer.playquran.models.Verses;
import com.aitekteam.developer.playquran.services.HttpsHandler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailPresenter extends ViewModel implements Callback<Verses> {
    private Context context;
    private LoaderHelper handler;
    private MutableLiveData<Verses> items;

    public void setContext(Context context, LoaderHelper handler) {
        this.context = context;
        this.handler = handler;
    }

    public MutableLiveData<Verses> getItems(
            int recitation,
            int translations,
            String language,
            String text_type,
            int page,
            Chapter item
    ) {
        if (items == null) {
            items = new MutableLiveData<>();
            Retrofit retrofitInstance = new Retrofit
                    .Builder()
                    .baseUrl(context.getResources().getString(R.string.api_url) + "chapters/" + item.getId() + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(HttpsHandler.getInstance().build())
                    .build();

            QuranAPI api = retrofitInstance.create(QuranAPI.class);
            Call<Verses> call = api.getVerses(
                    recitation,
                    translations,
                    language,
                    text_type,
                    page
            );
            handler.onStartLoad();
            call.enqueue(this);
        }
        return items;
    }

    @Override
    public void onResponse(Call<Verses> call, Response<Verses> response) {
        if (response.isSuccessful()) {
            items.postValue(response.body());
            handler.onFinishLoad(true, "Request Success");
        }
        else handler.onFinishLoad(false, "Something Wrong On Request To Server");
    }

    @Override
    public void onFailure(Call<Verses> call, Throwable t) {
        handler.onFinishLoad(false, "Failed To Request Server");
    }
}
