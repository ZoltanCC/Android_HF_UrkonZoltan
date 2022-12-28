package com.example.hf5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HaziFeladat extends AppCompatActivity {

    ListView mLista;
    List<String> list = new ArrayList<String>();
    String[] list_items = {"Asus ROG", "MSI Tomahawk", "Asrock", "Gigabyte", "Colorful"};
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hazi_feladat);
        mLista = findViewById(R.id.Lista);

        addContactList();

        adapter = new ArrayAdapter(HaziFeladat.this, R.layout.list_item,list);
        mLista.setAdapter(adapter);

        registerForContextMenu(mLista);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo i = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        TextView szinezdki = i.targetView.findViewById(R.id.szinezdki);
        switch (item.getItemId()){
            case R.id.red:
                szinezdki.setTextColor(Color.RED);
                return true;
            case R.id.green:
                szinezdki.setTextColor(Color.GREEN);
                return true;
            case R.id.yellow:
                szinezdki.setTextColor(Color.YELLOW);
                return true;
        }

        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo i = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.reorder:
                Collections.sort(list);
                adapter.notifyDataSetChanged();
                return true;

            case R.id.delete:
                list.clear();
                adapter.notifyDataSetChanged();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void addContactList(){
        for(String name : list_items){
            list.add(name);
        }
    }
}