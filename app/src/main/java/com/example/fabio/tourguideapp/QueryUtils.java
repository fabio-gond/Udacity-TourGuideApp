package com.example.fabio.tourguideapp;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.spec.ECField;
import java.util.ArrayList;

public class QueryUtils {
    public static ArrayList<Attraction> extractAttractions(String attractionType , Resources resources , Activity activity) {

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<Attraction> attractions = new ArrayList<>();

        String jsonFileContent = "";

        try {
            jsonFileContent = readFile("data.json", resources);
        }catch (Exception e){
            Log.e("QueryUtils", "extractAttractions: ", e );
        }

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
            JSONObject jsonObj = new JSONObject(jsonFileContent);

            // Getting JSON Array node
            JSONArray attractionsArray = jsonObj.getJSONArray(attractionType);
            for (int i = 0; i < attractionsArray.length(); i++) {
                JSONObject attractionObj = attractionsArray.getJSONObject(i);
                String name = attractionObj.getString("name");
                String description = attractionObj.getString("description");
                String address = attractionObj.getString("address");
                String photo = attractionObj.getString("photo");
                attractions.add(new Attraction(name , description , address , Api.getImgResourceId(photo,resources, activity)));
            }


        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the Attraction JSON results", e);
        }

        // Return the list of Attractions
        return attractions;
    }

    private static String readFile(String fileName , Resources resources) throws IOException
    {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(resources.getAssets().open(fileName), "UTF-8"));

        String content = "";
        String line;
        while ((line = reader.readLine()) != null)
        {
            content = content + line;
        }

        return content;

    }
}
