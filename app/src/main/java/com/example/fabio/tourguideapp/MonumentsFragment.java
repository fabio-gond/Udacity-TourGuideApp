package com.example.fabio.tourguideapp;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monuments, container, false);

        attractions.add(new Attraction("Sagrada Familia", "A beautiful church in Barcelona." , "Carrer de Mallorca, 401, 08013 Barcelona"));
        attractions.add(new Attraction("The Casa Batllo", "Is the most original and dreamlike house of the architect Antoni Gaudí in Barcelona." , "Passeig de Gràcia, 43, 08007 Barcelona"));


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

                // Start the new activity
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }


}
