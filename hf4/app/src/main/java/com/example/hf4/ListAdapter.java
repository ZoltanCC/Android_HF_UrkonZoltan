package com.example.hf4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<Country> {

    public ListAdapter(Context context, ArrayList<Country> countryArrayList){
        super(context, R.layout.listitem, countryArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Country country = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.countryFlag);
        TextView rovid = convertView.findViewById(R.id.rovid);
        TextView nev = convertView.findViewById(R.id.nev);
        TextView elad = convertView.findViewById(R.id.elad);
        TextView vesz = convertView.findViewById(R.id.vesz);

        imageView.setImageResource(country.imageID);
        rovid.setText(country.rovidNev);
        nev.setText(country.nev);
        elad.setText(String.valueOf(country.elad));
        vesz.setText(String.valueOf(country.vesz));

        return convertView;
    }
}