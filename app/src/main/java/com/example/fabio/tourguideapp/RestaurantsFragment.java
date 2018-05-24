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
public class RestaurantsFragment extends Fragment {
    private ArrayList<Attraction> attractions = new ArrayList<>();
    private static final String TAG = RestaurantsFragment.class.getSimpleName();
    private AttractionAdapter attractionAdapter;
    private ListView listView;


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);

        attractions.add(new Attraction(
                "Ciel Bleu Restaurant",
                "A modern restaurant near the canal." ,
                "Ferdinand Bolstraat 333, 1072 LH",
                api.getImgResourceId("restaurant1" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Restaurant La Rive",
                "A modern restaurant near the canal." ,
                "Professor Tulpplein 1, 1018 GX",
                api.getImgResourceId("restaurant2" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Blue Pepper",
                "A modern restaurant near the canal." ,
                "Nassaukade 366, 1054 AB",
                api.getImgResourceId("restaurant3" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Restaurant Daalder",
                "A modern restaurant near the canal." ,
                "Lindengracht 90, 1015 KK",
                api.getImgResourceId("restaurant4" , getResources() , getActivity())
        ));

        attractionAdapter = new AttractionAdapter(getActivity(), attractions);
        listView = view.findViewById(R.id.restaurants_list);
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
