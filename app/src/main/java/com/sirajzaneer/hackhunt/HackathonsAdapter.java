package com.sirajzaneer.hackhunt;

import android.content.Context;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by Siraj on 11/12/16.
 */

class HackathonsAdapter extends BaseAdapter {

    JSONObject obj;
    Context mContext;
    JSONObject[] arr;

    HackathonsAdapter(Context c, JSONObject json) {
        this.obj = json;
        this.mContext = c;
        System.out.println(obj.length());

        arr = new JSONObject[obj.length()];
        Iterator<?> keys = obj.keys();
        int i = 0;
        while (keys.hasNext()) {
            String key = (String)keys.next();
            try {
                arr[i++] = obj.getJSONObject(key);
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View hackView;
        JSONObject hackathon = (JSONObject) arr[position];

                LayoutInflater inflator = LayoutInflater.from(mContext);
                if (convertView == null) {
                    hackView = inflator.inflate(R.layout.hackathon_cell, null);
                } else {
                    hackView = convertView;
                }
                return hackView;
    }
}
