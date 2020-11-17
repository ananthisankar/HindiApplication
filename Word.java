package com.example.myhindi;
public class Word {

  private String mEnglishTranslation;
  private String mHindiTranslation;
  private int mImageResourceId = NO_IMAGE_PROVIDED;
  private static final int NO_IMAGE_PROVIDED = -1;
  private int mAudioResourceId;


  public Word(String mHindiTranslation , String mEnglishTranslation, int mAudioResourceId) {
    this.mEnglishTranslation = mEnglishTranslation;
    this.mHindiTranslation = mHindiTranslation;
    this.mAudioResourceId = mAudioResourceId;
  }

  public Word(String mHindiTranslation , String mEnglishTranslation, int mImageResourceId, int mAudioResourceId) {
    this.mEnglishTranslation = mEnglishTranslation;
    this.mHindiTranslation = mHindiTranslation;
    this.mImageResourceId = mImageResourceId;
    this.mAudioResourceId = mAudioResourceId;
  }

  public int getmAudioResourceId() {
    return mAudioResourceId;
  }


  public String getmEnglishTranslation() {
    return mEnglishTranslation;
  }

  public void setmEnglishTranslation(String mEnglishTranslation) {
    this.mEnglishTranslation = mEnglishTranslation;
  }

  public String getmHindiTranslation() {
    return mHindiTranslation;
  }

  public void setmHindiTranslation(String mHindiTranslation) {
    this.mHindiTranslation = mHindiTranslation;
  }

  public int getmImageResourceId() {
    return mImageResourceId;
  }


  public boolean hasImage(){
    return  mImageResourceId != NO_IMAGE_PROVIDED;
  }

  @Override public String toString() {
    return "Word{" +
        "mEnglishTranslation='" + mEnglishTranslation + '\'' +
        ", mHindiTranslation='" + mHindiTranslation + '\'' +
        ", mImageResourceId=" + mImageResourceId +
        ", mAudioResourceId=" + mAudioResourceId +
        '}';
  }
}
