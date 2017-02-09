package com.example.rishabhgoyal.booklist;

/**
 * Created by Rishabh Goyal on 09-02-2017.
 */

public class Result {

    private String mAuthour;
    private String mTitle;
    private String mPublisher;
    private String mPagecount;
    private String mRating;

    public Result(String author, String title, String publisher,String desc,String Rating) {
        mAuthour=author;
        mTitle=title;
        mPublisher=publisher;
        mPagecount=desc;
        mRating=Rating;
    }
/**Setter methods*/
    public void setmAuthour(String authour) {
        mAuthour=authour;
    }

    public void setmRating(String mRating) {
        this.mRating = mRating;
    }

    public void setmTitle(String title){
        mTitle=title;
    }
    public void setmPublisher(String pub){
        mPublisher=pub;
    }

    public void setmPagecount(String page) {
        this.mPagecount = page;
    }

    /**Getter methods*/
    public String getmAuthour() {
        return mAuthour;
    }
    public String getmPublisher() {
        return mPublisher;
    }
    public String getmTitle() {
        return mTitle;
    }

    public String getmRating() {
        return mRating;
    }

    public String getPagecount() {
        return mPagecount;
    }
}
