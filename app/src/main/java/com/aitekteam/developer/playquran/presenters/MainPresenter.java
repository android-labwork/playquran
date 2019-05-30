package com.aitekteam.developer.playquran.presenters;

import android.content.Context;

import com.aitekteam.developer.playquran.R;
import com.aitekteam.developer.playquran.interfaces.QuranAPI;
import com.aitekteam.developer.playquran.models.Chapters;
import com.aitekteam.developer.playquran.services.HttpsHandler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter extends ViewModel implements Callback<Chapters> {
    private Context context;
    private MainInterface handler;
    private MutableLiveData<Chapters> items;

    public void setContext(Context context, MainInterface handler) {
        this.context = context;
        this.handler = handler;
    }

    public MutableLiveData<Chapters> getItems() {
        if (items == null) {
            items = new MutableLiveData<>();
            Retrofit retrofitInstance = new Retrofit
                    .Builder()
                    .baseUrl(context.getResources().getString(R.string.api_url))
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(HttpsHandler.getInstance().build())
                    .build();

            QuranAPI api = retrofitInstance.create(QuranAPI.class);
            Call<Chapters> call = api.getChapters();
            handler.onStartLoad();
            call.enqueue(this);
        }
        return items;
    }

    @Override
    public void onResponse(Call<Chapters> call, Response<Chapters> response) {
        if (response.isSuccessful()) {
            items.postValue(response.body());
            handler.onFinishLoad(true, "Request Success");
        }
        else handler.onFinishLoad(false, "Something Wrong On Request To Server");
    }

    @Override
    public void onFailure(Call<Chapters> call, Throwable t) {
        handler.onFinishLoad(false, "Failed To Request Server");
    }

    public interface MainInterface {
        void onStartLoad();
        void onFinishLoad(boolean status, String msg);
    }
}
