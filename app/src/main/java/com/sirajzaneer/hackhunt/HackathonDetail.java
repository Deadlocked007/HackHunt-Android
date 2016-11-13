package com.sirajzaneer.hackhunt;

import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HackathonDetail extends AppCompatActivity {
    Hackathon hackathon;
    Image poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        hackathon = (Hackathon) getIntent().getSerializableExtra("hackathon");
        toolbar.setTitle("hi");
        ImageView poster = (ImageView) findViewById(R.id.detailPosterImage);

        AppBarLayout appBar = (AppBarLayout) findViewById(R.id.app_bar);
        Picasso.with(this).load(hackathon.imageUrl).into(poster);
        poster.setAdjustViewBounds(true);
        poster.setScaleType(ImageView.ScaleType.FIT_XY);


    }
}
