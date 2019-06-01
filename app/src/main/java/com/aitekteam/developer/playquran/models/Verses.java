package com.aitekteam.developer.playquran.models;

import com.aitekteam.developer.playquran.data.Verse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Verses implements Serializable {
    @SerializedName("verses")
    private ArrayList<Verse> items;
    @SerializedName("meta")
    private Meta meta;

    public class Meta implements Serializable {
        @SerializedName("current_page")
        private int currentPage;
        @SerializedName("next_page")
        private int nextPage;
        @SerializedName("prev_page")
        private int prevPage;
        @SerializedName("total_pages")
        private int totalPages;
        @SerializedName("total_count")
        private int totalCount;

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getPrevPage() {
            return prevPage;
        }

        public void setPrevPage(int prevPage) {
            this.prevPage = prevPage;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
    }

    public ArrayList<Verse> getItems() {
        return items;
    }

    public void setItems(ArrayList<Verse> items) {
        this.items = items;
    }
}
