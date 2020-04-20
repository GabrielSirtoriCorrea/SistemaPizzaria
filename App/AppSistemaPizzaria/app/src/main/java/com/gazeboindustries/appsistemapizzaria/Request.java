package com.gazeboindustries.appsistemapizzaria;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Request extends Activity implements CompoundButton.OnCheckedChangeListener{

    ListView listView;
    List<SaborPizza> list = new ArrayList<>();

    ListViewAdapter versionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request1);

        listView = findViewById(R.id.ListRequest1Sabor);

        list = new ArrayList<>();

        list.add(new SaborPizza("Brócolis", "R$ 10"));
        list.add(new SaborPizza("Peperone", "R$ 20"));
        list.add(new SaborPizza("Calabresa", "R$ 10"));
        list.add(new SaborPizza("Frango", "R$ 15"));
        list.add(new SaborPizza("Bacon", "R$ 30"));
        list.add(new SaborPizza("Saboiestojo", "R$ 100"));

        versionAdapter = new ListViewAdapter(Request.this,R.layout.item_row,list);
        listView.setAdapter(versionAdapter);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int position = listView.getPositionForView(compoundButton);

        if (position != ListView.INVALID_POSITION){

            SaborPizza sabor = list.get(position);
            sabor.setSelected(b);



            Toast.makeText(this, "Selected : "+ sabor.getTaste(), Toast.LENGTH_SHORT).show();
        }
    }
}
