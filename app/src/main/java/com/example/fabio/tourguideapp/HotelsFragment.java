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
public class HotelsFragment extends Fragment {
    private ArrayList<Attraction> attractions = new ArrayList<>();
    private static final String TAG = HotelsFragment.class.getSimpleName();
    private AttractionAdapter attractionAdapter;
    private ListView listView;


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hotels, container, false);

        attractions.add(new Attraction(
                "Waldorf Astoria Amsterdam",
                "Beautiful hotel on the canal" ,
                "Herengracht 542-556, 1017 CG",
                api.getImgResourceId("hotel1" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Luxury Suites Amsterdam",
                "Elegant suites in a luxury hotels with bar." ,
                "Oudeschans 75, 1011 KW",
                api.getImgResourceId("hotel2" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "XO Hotels Couture",
                "Modern rooms in a luxury hotel on multiple floors." ,
                "Delflandlaan 15, 1062 EA",
                api.getImgResourceId("hotel3" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Hotel Sofitel Legend the Grand Amsterdam",
                "Luxury hotel in the center of Amsterdam." ,
                "Oudezijds Voorburgwal 197, 1012 EX",
                api.getImgResourceId("hotel4" , getResources() , getActivity())
        ));

        attractionAdapter = new AttractionAdapter(getActivity(), attractions);
        listView = view.findViewById(R.id.hotels_list);
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
