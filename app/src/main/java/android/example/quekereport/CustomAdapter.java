package android.example.quekereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomAdapter extends ArrayAdapter<QuakeInfo> {

    public CustomAdapter(Activity context, ArrayList<QuakeInfo> quakeInfos) {
        super(context, 0,quakeInfos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);


        QuakeInfo currentQuakeinfo = getItem(position);

        // get magnitude textview and set its text
        TextView magTextview = listItemView.findViewById(R.id.mag);
        double mag = currentQuakeinfo.getmMag();
        magTextview.setText(formatMagnitude(mag));

        // change the color of magnitude background
        GradientDrawable magCircle = (GradientDrawable) magTextview.getBackground();
        int magColor = getMagColor(mag);
        magCircle.setColor(magColor);

        //get location textview and set its text
        TextView locationTextview1 = listItemView.findViewById(R.id.location_1);
        TextView locationTextview2 = listItemView.findViewById(R.id.location_2);

        String location = currentQuakeinfo.getmLocation();
        String locationOffset;
        String locationPrimary;
        String SPLIT_POINT = "of ";

        if(location.contains(SPLIT_POINT)){
            locationOffset = location.split(SPLIT_POINT)[0].toString() +SPLIT_POINT;
            locationPrimary = location.split(SPLIT_POINT)[1].toString();
        }else{
            locationOffset = "Near the";
            locationPrimary = location;
        }

        locationTextview1.setText(locationOffset);
        locationTextview2.setText(locationPrimary);

        // get date textView and set its text to the time after formatting it
        Long time = currentQuakeinfo.getmDate();
        Date date = new Date(time);

        TextView dateTextview1 = listItemView.findViewById(R.id.date_1);
        TextView dateTextview2= listItemView.findViewById(R.id.date_2);

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMM DD, yyyy");
        String date1ToDisplay = dateFormat1.format(date);

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("h:mm a");
        String date2ToDisplay = dateFormat2.format(date);

        dateTextview1.setText(date1ToDisplay);
        dateTextview2.setText(date2ToDisplay);

        return listItemView;
    }

    private String formatMagnitude(double mag){
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(mag);
    }

    private int getMagColor(double mag){
        int color;
        int magValue =(int) Math.floor(mag);

        switch (magValue){
            case 0:
            case 1:
                color = R.color.magnitude1;
                break;
            case 2:
                color = R.color.magnitude2;
                break;
            case 3:
                color = R.color.magnitude3;
                break;
            case 4:
                color = R.color.magnitude4;
                break;
            case 5:
                color = R.color.magnitude5;
                break;
            case 6:
                color = R.color.magnitude6;
                break;
            case 7:
                color = R.color.magnitude7;
                break;
            case 8:
                color = R.color.magnitude8;
                break;
            case 9:
                color = R.color.magnitude9;
                break;
            default:
                color = R.color.magnitude10;
                break;
        }

        return ContextCompat.getColor(getContext(),color);
    }
}
