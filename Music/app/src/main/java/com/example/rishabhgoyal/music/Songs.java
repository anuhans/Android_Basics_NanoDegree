package com.example.rishabhgoyal.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.M;
import static com.example.rishabhgoyal.music.R.id.songs;

public class Songs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        TextView artists=(TextView)findViewById(R.id.artist);
        TextView genres=(TextView)findViewById(R.id.genre);
        TextView playlist=(TextView)findViewById(R.id.playlist);
        TextView nowplaying=(TextView)findViewById(R.id.now_playing);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Songs.this,Artists.class);
                startActivity(i);
            }
        });
        nowplaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Songs.this,MainActivity.class);
                startActivity(i);
            }
        });
        genres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Songs.this,Genres.class);
                startActivity(i);
            }
        });
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Songs.this,Playlist.class);
                startActivity(i);
            }
        });
    }
}
