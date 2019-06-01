package com.aitekteam.developer.playquran.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aitekteam.developer.playquran.R;
import com.aitekteam.developer.playquran.data.Chapter;
import com.aitekteam.developer.playquran.models.Chapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersAdapter.ViewHolder> {
    private Chapters items;
    private OnChapterSelectedItem handler;

    public ChaptersAdapter(Chapters items, OnChapterSelectedItem handler) {
        this.items = items;
        this.handler = handler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_chapters,
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chapter item = items.getItems().get(position);
        holder.title.setText(item.getName());
        holder.description.setText(item.getTranslatedName().getName());
        holder.category.setText(item.getNameArabic());
        holder.page.setText(String.valueOf(item.getVersesCount()) + " pages");
    }

    @Override
    public int getItemCount() {
        return items.getItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, description, category, page;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_title);
            description = itemView.findViewById(R.id.item_description);
            category = itemView.findViewById(R.id.item_category);
            page = itemView.findViewById(R.id.item_page);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            handler.onSeletedItem(getAdapterPosition());
        }
    }

    public interface OnChapterSelectedItem {
        void onSeletedItem(int position);
    }
}
