package com.aitekteam.developer.playquran.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Chapter implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("chapter_number")
    private int chapterNumber;
    @SerializedName("revelation_order")
    private int revelationOrder;
    @SerializedName("verses_count")
    private int versesCount;
    @SerializedName("revelation_place")
    private String revelationPlace;
    @SerializedName("name_complex")
    private String name;
    @SerializedName("name_arabic")
    private String nameArabic;
    @SerializedName("translated_name")
    private TranslatedName translatedName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public int getRevelationOrder() {
        return revelationOrder;
    }

    public void setRevelationOrder(int revelationOrder) {
        this.revelationOrder = revelationOrder;
    }

    public int getVersesCount() {
        return versesCount;
    }

    public void setVersesCount(int versesCount) {
        this.versesCount = versesCount;
    }

    public String getRevelationPlace() {
        return revelationPlace;
    }

    public void setRevelationPlace(String revelationPlace) {
        this.revelationPlace = revelationPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameArabic() {
        return nameArabic;
    }

    public void setNameArabic(String nameArabic) {
        this.nameArabic = nameArabic;
    }

    public TranslatedName getTranslatedName() {
        return translatedName;
    }

    public void setTranslatedName(TranslatedName translatedName) {
        this.translatedName = translatedName;
    }

    public class TranslatedName {
        @SerializedName("language_name")
        private String languageName;
        @SerializedName("name")
        private String name;

        public String getLanguageName() {
            return languageName;
        }

        public void setLanguageName(String languageName) {
            this.languageName = languageName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
