package com.example.bottomnavigationapp.fragments;


import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.bottomnavigationapp.R;
import com.example.bottomnavigationapp.adapters.ProfileAdapter;
import com.example.bottomnavigationapp.pojo.Profile;
import com.example.bottomnavigationapp.singleton.Singleton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private static final String URL = "https://api.github.com/users";
    private RecyclerView recycler_profile;
    private ProfileAdapter profileAdapter;
    private ArrayList<Profile> profileArrayList;
    private ProgressBar pbar_profile;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
               View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        recycler_profile = view.findViewById(R.id.recycler_profile);
        pbar_profile = view.findViewById(R.id.pbar_profile);
        profileArrayList = new ArrayList<>();
        fetchProfiles();
        profileAdapter = new ProfileAdapter(getActivity(),profileArrayList);
        recycler_profile.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_profile.setAdapter(profileAdapter);

        recycler_profile.setItemAnimator(new DefaultItemAnimator());



        return view;
    }

    private void fetchProfiles(){

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response !=null){

                 ArrayList<Profile> profileItem;
                    profileItem = new Gson().fromJson(response.toString(),new TypeToken<ArrayList<Profile>>(){}
                    .getType());

                    profileArrayList.addAll(profileItem);
                    pbar_profile.setVisibility(View.GONE);



                }else {
                    Toast.makeText(getActivity(), "Response not found", Toast.LENGTH_SHORT).show();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();

            }
        });

        Singleton.getInstance().addToRequestQueue(request);

    }

}
