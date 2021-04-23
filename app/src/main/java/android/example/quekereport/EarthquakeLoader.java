package android.example.quekereport;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<QuakeInfo>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader (Context context, String url){
        super(context);
        mUrl = url;
    }

    // it didnt work till i added this method
    @Override
    protected  void onStartLoading(){
        forceLoad();
    }

    @Nullable
    @Override
    public List<QuakeInfo> loadInBackground() {
        if(mUrl == null){
            return null;
        }
        List<QuakeInfo> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
