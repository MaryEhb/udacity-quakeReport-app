package android.example.quekereport;

import java.util.Date;

public class QuakeInfo {
    private double mMag;
    private String mLocation;
    private long mDate;
    private String mUrl;

    public QuakeInfo(double mag, String location, long date, String url){
        mMag = mag;
        mLocation = location;
        mDate = date;
        mUrl = url;
    }

    public double getmMag() {
        return mMag;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmDate() {
        return mDate;
    }

    public String getUrl(){ return mUrl; }
}
