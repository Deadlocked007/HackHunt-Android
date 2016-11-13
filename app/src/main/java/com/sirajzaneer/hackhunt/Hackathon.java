package com.sirajzaneer.hackhunt;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Siraj on 11/12/16.
 */

public class Hackathon {
    String name;
    String link;
    String imageUrl;
    String logoImageUrl;
    String location;
    String dateString;
    Date startDate;
    Date endDate;

    public Hackathon(JSONObject json) {
        try {
            name = json.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
