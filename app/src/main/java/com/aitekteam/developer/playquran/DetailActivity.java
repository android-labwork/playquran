package com.aitekteam.developer.playquran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.aitekteam.developer.playquran.adapters.VersesAdapter;
import com.aitekteam.developer.playquran.data.Chapter;
import com.aitekteam.developer.playquran.interfaces.LoaderHelper;
import com.aitekteam.developer.playquran.models.Verses;
import com.aitekteam.developer.playquran.presenters.DetailPresenter;

public class DetailActivity extends AppCompatActivity implements LoaderHelper {

    private RecyclerView listVerses;
    private DetailPresenter detailPresenter;
    private ProgressDialog loading;
    private int page;
    private Chapter item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        listVerses = findViewById(R.id.list_verses);
        listVerses.setLayoutManager(new LinearLayoutManager(this));
        page = 1;
        item = (Chapter) getIntent().getExtras().getSerializable("chapter");

        detailPresenter = ViewModelProviders.of(this).get(DetailPresenter.class);
        detailPresenter.setContext(this, this);
        detailPresenter.getItems(
            1,
            21,
            "en",
            "words",
            page,
            item
        ).observe(this, getVerses);
    }

    private Observer<Verses> getVerses = new Observer<Verses>() {
        @Override
        public void onChanged(Verses verses) {
            listVerses.setAdapter(new VersesAdapter(verses, new VersesAdapter.OnVerseSelectedItem() {
                @Override
                public void onSeletedItem(int position) {

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
