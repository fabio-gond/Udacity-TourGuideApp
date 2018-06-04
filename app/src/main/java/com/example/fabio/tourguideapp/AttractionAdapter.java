package com.example.fabio.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {
    public AttractionAdapter(@NonNull Context context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);
        TextView name= listItemView.findViewById(R.id.attractionItem_name);
        name.setText(currentAttraction.getName());
        ImageView photo = listItemView.findViewById(R.id.attractionItem_photo);
        photo.setImageResource(currentAttraction.getImgResourceId());
        TextView description= listItemView.findViewById(R.id.attractionItem_description);
        description.setText(currentAttraction.getDescription());
        return listItemView;
    }
}
