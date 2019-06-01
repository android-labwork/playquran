package com.aitekteam.developer.playquran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.aitekteam.developer.playquran.adapters.ChaptersAdapter;
import com.aitekteam.developer.playquran.interfaces.LoaderHelper;
import com.aitekteam.developer.playquran.models.Chapters;
import com.aitekteam.developer.playquran.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements LoaderHelper {

    private MainPresenter mainPresenter;
    private RecyclerView listQuran;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listQuran = findViewById(R.id.list_quran);
        listQuran.setLayoutManager(new LinearLayoutManager(this));
        mainPresenter = ViewModelProviders.of(this).get(MainPresenter.class);
        mainPresenter.setContext(this, this);
        mainPresenter.getItems().observe(this, getChapters);
    }

    private Observer<Chapters> getChapters = new Observer<Chapters>() {
        @Override
        public void onChanged(final Chapters chapters) {
            listQuran.setAdapter(new ChaptersAdapter(chapters, new ChaptersAdapter.OnChapterSelectedItem() {
                @Override
                public void onSeletedItem(int position) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("chapter", chapters.getItems().get(position));
                    startActivity(intent);
                }
            }));
        }
    };

    @Override
    public void onStartLoad() {
        loading = new ProgressDialog(this);
        loading.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loading.setMessage("Please Wait...");
        loading.show();
    }

    @Override
    public void onFinishLoad(boolean status, String msg) {
        loading.dismiss();
    }
}
