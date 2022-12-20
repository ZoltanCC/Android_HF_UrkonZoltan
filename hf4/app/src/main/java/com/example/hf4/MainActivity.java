package com.example.hf4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.hf4.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Country usa = new Country("Dolar american","USD",3.9750,4.1450,R.drawable.usa);
        Country eur = new Country("Euro","EUR",4.4100,4.5500,R.drawable.europa);
        Country ang = new Country("Lira sterlina","GBP",6.1250,6.3550,R.drawable.anglia);
        Country kan = new Country("Dolar canadian","CAD",3.0950,3.2650,R.drawable.kanada);
        Country dan = new Country("Corona daneza","DKK",0.5850,0.6150,R.drawable.denmark);
        Country hun = new Country("Forint maghiar","HUF",0.0136,0.0146,R.drawable.magyar);
        Country svj = new Country("Franc elvetian","CHF",4.2300,4.3300,R.drawable.svajc);

        ArrayList<Country> countryList = new ArrayList<>();

        countryList.add(usa);
        countryList.add(eur);
        countryList.add(ang);
        countryList.add(kan);
        countryList.add(dan);
        countryList.add(hun);
        countryList.add(svj);

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,countryList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.findViewById(R.id.elad).setVisibility(View.VISIBLE);
                view.findViewById(R.id.textView5).setVisibility(View.VISIBLE);
                view.findViewById(R.id.textView7).setVisibility(View.VISIBLE);
                view.findViewById(R.id.vesz).setVisibility(View.VISIBLE);
                view.findViewById(R.id.textView).setVisibility(View.VISIBLE);
                view.findViewById(R.id.textView9).setVisibility(View.VISIBLE);
            }
        });
    }
}