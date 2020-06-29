package com.example.listitemclick;

public class ResourceClass {
    String englishP="";
    String arabicP="";
    int audioResource=0;

    public ResourceClass(String englishP, String arabicP,int audioResource){
        this.englishP=englishP;
        this.arabicP=arabicP;
        this.audioResource=audioResource;
    }

    public ResourceClass(){}

    public String getEnglishP() {return englishP;}
    public int getAudioResource() {return audioResource;}
    public String getArabicP() {return arabicP;}
}
