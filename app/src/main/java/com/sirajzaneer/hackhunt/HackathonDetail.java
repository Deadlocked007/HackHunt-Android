package com.sirajzaneer.hackhunt;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
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



        hackathon = (Hackathon) getIntent().getSerializableExtra("hackathon");
        ImageView poster = (ImageView) findViewById(R.id.detailPosterImage);

        toolbar.setTitle(hackathon.name);
        setSupportActionBar(toolbar);
        AppBarLayout appBar = (AppBarLayout) findViewById(R.id.app_bar);
        Picasso.with(this).load(hackathon.imageUrl).into(poster);
        poster.setAdjustViewBounds(true);
        poster.setScaleType(ImageView.ScaleType.FIT_XY);
        Button but = (Button) findViewById(R.id.button);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(hackathon.link); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }
}
