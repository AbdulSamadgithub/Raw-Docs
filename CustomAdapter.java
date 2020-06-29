package com.example.listitemclick;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ResourceClass> {
    public CustomAdapter(Activity context, ArrayList<ResourceClass> arrayList){
        super(context,0,arrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view==null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.phraseslayout,parent,false);
        }

        final ResourceClass rObject =getItem(position);

        TextView english = view.findViewById(R.id.englishwords);
        english.setText(rObject.getEnglishP());


        /**
         * On click on the Arabic textview
         */
        final TextView arabic = view.findViewById(R.id.arabicwords);
        arabic.setText(rObject.getArabicP());
        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),arabic.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        //setting the on click listener here on the view
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),rObject.getAudioResource());
                mediaPlayer.start();
            }
        });


        return view;

    }
}
