package de.mvo.playground;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void loadPicture(View view) {
        final ImageView imageView = findViewById(R.id.beerImage);

        Picasso.with(this)
                .load("https://src.discounto.de/pics/Angebote/2017-10/2231258/3331710_Hasseroeder-Pils_xxl.jpg")
                .into(imageView);

        Snackbar.make(view, "Hasseröder rockt!", Snackbar.LENGTH_INDEFINITE).setAction("Weg damit!",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setImageResource(android.R.drawable.ic_menu_search);
                    }
                }).show();
    }

}
