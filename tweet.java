package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class tweet {
    public String body;
    public  String createdAt;
    public long id;
    public User user;

    public static tweet fromJson(JSONObject jsonObject) throws JSONException {
        tweet Tweet = new tweet();
        Tweet.body= jsonObject.getString("text");
        Tweet.createdAt= jsonObject.getString( "created_at");
        jsonObject.getLong("id");
        Tweet.user=User.fromJson( jsonObject.getJSONObject("user"));

        return Tweet;
    }
    public static List<tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<tweet> tweets=new ArrayList<>();
        for (int i = 0; i < jsonArray.length();i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
}

