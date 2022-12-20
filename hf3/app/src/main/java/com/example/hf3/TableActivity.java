package com.example.hf3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        List<Product> lista = new ArrayList<Product>();
        Button cancel = (Button) findViewById(R.id.cancel);
        Button add = (Button) findViewById(R.id.add);
        Button show = (Button) findViewById(R.id.show);
        TextView code = (TextView) findViewById(R.id.code);
        TextView name = (TextView) findViewById(R.id.name);
        TextView price = (TextView) findViewById(R.id.price);
        TextView listaa = (TextView) findViewById(R.id.lista);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                code.setText("");
                name.setText("");
                price.setText("");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!code.getText().toString().matches("") && !name.getText().toString().matches("") && !price.getText().toString().matches(""))
                    lista.add(new Product(code.getText().toString(),name.getText().toString(),Double.parseDouble(price.getText().toString())));
                code.setText("");
                name.setText("");
                price.setText("");
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ossz = "";
                for (Product product: lista) {
                    ossz += product.toString();
                    ossz += "\n";
                }

                listaa.setText(ossz);
            }
        });
    }
}