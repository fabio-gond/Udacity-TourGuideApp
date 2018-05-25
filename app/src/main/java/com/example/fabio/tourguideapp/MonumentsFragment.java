package com.example.fabio.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonumentsFragment extends Fragment {
    private ArrayList<Attraction> attractions = new ArrayList<>();
    private static final String TAG = MonumentsFragment.class.getSimpleName();
    private AttractionAdapter attractionAdapter;
    private ListView listView;



    public MonumentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_monuments, container, false);


        attractions.add(new Attraction(
                "Stedelijk Museum",
                "A beautiful Museum." ,
                "Museumplein 10, 1071 DJ, Amsterdam",
                api.getImgResourceId("stedelijk_museum" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Van Gogh Museum",
                "This museum is dedicated to Van Gogh." ,
                "Museumplein 6, 1071 DJ, Amsterdam",
                api.getImgResourceId("van_gogh_museum" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Anna Frank House",
                "In this house lived Anna Frank." ,
                "Prinsengracht 263-267, 1016 GV, Amsterdam",
                api.getImgResourceId("anne_frank_house" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Rembrandt House",
                "The house of the famous artist." ,
                "Jodenbreestraat 4, 1011 NK, Amsterdam",
                api.getImgResourceId("rembrandt_house" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Rijksmuseum",
                "A big museum in Amsterdam." ,
                "Museumstraat 1, 1071 XX, Amsterdam",
                api.getImgResourceId("rijksmuseum" , getResources() , getActivity())
        ));



        attractionAdapter = new AttractionAdapter(getActivity(), attractions);
        listView = view.findViewById(R.id.monuments_list);
        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Create a new intent
                Intent intent = new Intent(getActivity(), AttractionActivity.class);
                intent.putExtra("name", attractions.get(i).getName());
                intent.putExtra("description", attractions.get(i).getDescription());
                intent.putExtra("address", attractions.get(i).getAddress());
                intent.putExtra("photo", attractions.get(i).getImgResourceId());

                // Start the new activity
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }


}
