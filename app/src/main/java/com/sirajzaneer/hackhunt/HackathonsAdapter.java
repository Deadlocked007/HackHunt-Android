package com.sirajzaneer.hackhunt;

import android.content.Context;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Iterator;

import static com.sirajzaneer.hackhunt.R.id.imageView;

/**
 * Created by Siraj on 11/12/16.
 */

class HackathonsAdapter extends BaseAdapter {

    JSONObject obj;
    Context mContext;
    Hackathon[] arr;

    HackathonsAdapter(Context c, JSONObject json) {
        this.obj = json;
        this.mContext = c;
        System.out.println(obj.length());

        arr = new Hackathon[obj.length()];
        Iterator<?> keys = obj.keys();
        int i = 0;
        while (keys.hasNext()) {
            String key = (String)keys.next();
            try {
                arr[i++] = new Hackathon(obj.getJSONObject(key));
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public int getCount() {
        return obj.length();
    }

    @Override
    public Object getItem(int position) {
        return arr[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public Hackathon[] getHackathons() {
        return arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View hackView;
        Hackathon hackathon = arr[position];

                LayoutInflater inflator = LayoutInflater.from(mContext);
                if (convertView == null) {
                    hackView = inflator.inflate(R.layout.hackathon_cell, null);
                    TextView name = (TextView) hackView.findViewById(R.id.hackathonName);
                    name.setText(hackathon.name);
                    TextView date = (TextView) hackView.findViewById(R.id.hackathonDate);
                    date.setText(hackathon.dateString);
                    TextView location = (TextView) hackView.findViewById(R.id.hackathonLocation);
                    location.setText(hackathon.location);
                    ImageView image = (ImageView) hackView.findViewById(R.id.posterImage);
                    Picasso.with(mContext).load(hackathon.imageUrl).into(image);

                } else {
                    hackView = convertView;
                    TextView name = (TextView) hackView.findViewById(R.id.hackathonName);
                    name.setText(hackathon.name);
                    TextView date = (TextView) hackView.findViewById(R.id.hackathonDate);
                    date.setText(hackathon.dateString);
                    TextView location = (TextView) hackView.findViewById(R.id.hackathonLocation);
                    location.setText(hackathon.location);
                    ImageView image = (ImageView) hackView.findViewById(R.id.posterImage);
                    Picasso.with(mContext).load(hackathon.imageUrl).into(image);
                }


                return hackView;
    }
}
