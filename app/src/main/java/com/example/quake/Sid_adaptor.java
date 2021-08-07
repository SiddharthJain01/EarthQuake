package com.example.quake;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Sid_adaptor extends ArrayAdapter<EarthQuake> {
    public Sid_adaptor(@NonNull Context context, ArrayList<EarthQuake> arr) {
        super(context, 0, arr);
    }

    @Override
    public EarthQuake getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.sidlayout,parent,false);
        }
        EarthQuake gtt=getItem(position);




        String string = gtt.getPlace();
        String[] parts = string.split("of");
        String part1 = parts[0]; // 004
        String part2 = parts[1];
        TextView textView=convertView.findViewById(R.id.textView);
        String formattedMagnitude = formatMagnitude(gtt.getMag());
        textView.setText(formattedMagnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) textView.getBackground();
        int magnitudeColor = getMagnitudeColor(gtt.getMag());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);



        TextView textView6=convertView.findViewById(R.id.textView6);
        textView6.setText(part1);TextView textView5=convertView.findViewById(R.id.textView5);
        textView5.setText(part2);
        TextView textView3=convertView.findViewById(R.id.textView3);
        textView3.setText( gtt.getTime());
        return convertView;
    }

    private String formatMagnitude(double mag) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(mag);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
