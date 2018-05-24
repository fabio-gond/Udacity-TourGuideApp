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
public class ClubsFragment extends Fragment {
    private ArrayList<Attraction> attractions = new ArrayList<>();
    private static final String TAG = ClubsFragment.class.getSimpleName();
    private AttractionAdapter attractionAdapter;
    private ListView listView;


    public ClubsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_clubs, container, false);

        attractions.add(new Attraction(
                "De Club Up",
                "A night club near the center of the city." ,
                "Korte Leidsedwarsstraat 26-1, 1017 RC",
                api.getImgResourceId("club1" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Winston Kingdom Club",
                "A night club near the center of the city." ,
                "Warmoesstraat 131, 1012 JA",
                api.getImgResourceId("club2" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "Sugar Factory",
                "A night club near the center of the city." ,
                "Lijnbaansgracht 238, 1017 PH",
                api.getImgResourceId("club3" , getResources() , getActivity())
        ));
        attractions.add(new Attraction(
                "AIR Amsterdam",
                "A night club near the center of the city." ,
                "Amstelstraat 16, 1017 DA",
                api.getImgResourceId("club4" , getResources() , getActivity())
        ));

        attractionAdapter = new AttractionAdapter(getActivity(), attractions);
        listView = view.findViewById(R.id.clubs_list);
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
