package com.example.listitemclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ResourceClass resourceClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);

        resourceClass = new ResourceClass();
        Button button = findViewById(R.id.PhrasesActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.congratulations);
                mediaPlayer.start();
            }
        });

        final ArrayList<ResourceClass> arrayList = new ArrayList<>();
        arrayList.add(new ResourceClass("GoodBye","GUDBY",R.raw.goodbye));
        arrayList.add(new ResourceClass("I Love You","AnaAhubik",R.raw.i_love_you));

        //does not work with this custom array adapter
        final CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,arrayList);


        final ArrayList<String> arrayList1= new ArrayList<>();
        arrayList1.add("one");
        arrayList1.add("Two");
        arrayList1.add("three");
        arrayList1.add("four");
        arrayList1.add("five");
        arrayList1.add("six");
        arrayList1.add("seven");
        arrayList1.add("eight");
        arrayList1.add("nine");
        arrayList1.add("ten");

        //works with this string adapter
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList1);


        final ListView listView = findViewById(R.id.list);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Toast Message", Toast.LENGTH_SHORT).show();
            }
        });

    }
}