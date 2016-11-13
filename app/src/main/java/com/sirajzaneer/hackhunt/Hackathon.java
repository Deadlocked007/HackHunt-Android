package com.sirajzaneer.hackhunt;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Siraj on 11/12/16.
 */

@SuppressWarnings("serial")
class Hackathon implements Serializable {
    String name;
    String link;
    String imageUrl;
    String logoImageUrl;
    String location;
    String dateString;
    Date startDate;
    Date endDate;

    Hackathon(JSONObject json) {
        try {
            name = json.getString("name");
            location = json.getString("location");
            dateString = json.getString("date");
            imageUrl = json.getString("image");
            link = json.getString("link");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
