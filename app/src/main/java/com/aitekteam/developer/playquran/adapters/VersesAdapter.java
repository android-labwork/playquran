package com.aitekteam.developer.playquran.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aitekteam.developer.playquran.R;
import com.aitekteam.developer.playquran.data.Verse;
import com.aitekteam.developer.playquran.models.Verses;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.ViewHolder> {
    private Verses items;
    private OnVerseSelectedItem handler;

    public VersesAdapter(Verses items, OnVerseSelectedItem handler) {
        this.items = items;
        this.handler = handler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_verses,
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Verse item = items.getItems().get(position);
        holder.itemText.setText(item.getTextMadani());
        holder.itemTextTranslate.setText(item.getTranslations().get(0).getText());
    }

    @Override
    public int getItemCount() {
        return items.getItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemText, itemTextTranslate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemText = itemView.findViewById(R.id.item_text);
            itemTextTranslate = itemView.findViewById(R.id.item_text_translate);
        }
    }

    public interface OnVerseSelectedItem {
        void onSeletedItem(int position);
    }
}
