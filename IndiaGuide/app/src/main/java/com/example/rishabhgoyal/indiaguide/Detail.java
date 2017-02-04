package com.example.rishabhgoyal.indiaguide;

/**
 * Created by Rishabh Goyal on 04-02-2017.
 */

public class Detail {

    private int mName;
    private int mReview;
    private int mImageResourceId=NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED=-1;

    public Detail(int name, int review) {
        mName = name;
        mReview = review;
    }

    public Detail(int name, int review, int imageResourceId) {
        mName = name;
        mReview = review;
        mImageResourceId = imageResourceId;
    }

    public int getName() {
        return mName;
    }
    public int getReview() {
        return mReview;
    }
    public int getimageid() {
        return mImageResourceId;
    }
    public boolean hasimage(){
        return mImageResourceId !=NO_IMAGE_PROVIDED;
    }

}
