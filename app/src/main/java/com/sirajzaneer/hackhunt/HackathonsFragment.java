package com.sirajzaneer.hackhunt;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Siraj on 11/12/16.
 */

public class HackathonsFragment extends Fragment {

    HackathonsAdapter adapter;
    GridView hackathonsGrid;
    String baseUrl = "http://pacific-hollows-46235.herokuapp.com/na-2017";
    Context c;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View content = inflater.inflate(R.layout.fragment_hackathons, container, false);
        hackathonsGrid = (GridView) content.findViewById(R.id.hackathonGrid);

        c =  this.getContext();

        new LoadHackathons().execute();


        return content;
    }

    public class LoadHackathons extends AsyncTask<Void, Void, Boolean> {


        JSONObject resultJ;

        @Override
        protected Boolean doInBackground(Void... params) {

            StringBuilder result = new StringBuilder();
            try {
                // Simulate network access.
                URL url = new URL(baseUrl);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    result.append(line);
                }

                System.out.println("hi");
                resultJ = new JSONObject(result.toString());
                return true;
                //Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                // for ( int c = in.read(); c != -1; c = in.read() )
                //   line += (char)c;
                // System.out.println(line);
            } catch (Exception e) {
                return false;
            }


        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean) {
                adapter = new HackathonsAdapter(c, resultJ);
                hackathonsGrid.setAdapter(adapter);

                hackathonsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(c, HackathonDetail.class);
                        Hackathon hackathon = adapter.getHackathons()[position];
                        intent.putExtra("hackathon", hackathon);
                        startActivity(intent);

                    }
                });
            }
        }
    }
}
