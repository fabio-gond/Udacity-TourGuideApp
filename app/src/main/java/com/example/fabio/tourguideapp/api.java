package com.example.fabio.tourguideapp;

import android.app.Activity;
import android.content.res.Resources;

public class api {

    /**
     * Return the image resource id from the image name
     *
     * @param name
     * @param resources getResources()
     * @param activity
     * @return
     */
    public static int getImgResourceId(String name , Resources resources , Activity activity){
        return resources.getIdentifier(name, "drawable", activity.getPackageName());
    }
}
