package com.aitekteam.developer.playquran.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Verse implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("chapter_id")
    private int chapterId;
    @SerializedName("juz_number")
    private int juzNumber;
    @SerializedName("text_madani")
    private String textMadani;
    @SerializedName("translations")
    private ArrayList<Translations> translations;

    public class Translations implements Serializable {
        @SerializedName("id")
        private int id;
        @SerializedName("language_name")
        private String languageName;
        @SerializedName("text")
        private String text;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLanguageName() {
            return languageName;
        }

        public void setLanguageName(String languageName) {
            this.languageName = languageName;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getJuzNumber() {
        return juzNumber;
    }

    public void setJuzNumber(int juzNumber) {
        this.juzNumber = juzNumber;
    }

    public String getTextMadani() {
        return textMadani;
    }

    public void setTextMadani(String textMadani) {
        this.textMadani = textMadani;
    }

    public ArrayList<Translations> getTranslations() {
        return translations;
    }

    public void setTranslations(ArrayList<Translations> translations) {
        this.translations = translations;
    }
}
