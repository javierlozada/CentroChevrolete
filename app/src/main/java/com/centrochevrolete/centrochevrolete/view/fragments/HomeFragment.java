package com.centrochevrolete.centrochevrolete.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.centrochevrolete.centrochevrolete.R;
import com.centrochevrolete.centrochevrolete.adapter.PictureAdapteRecyclerView;
import com.centrochevrolete.centrochevrolete.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home), false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapteRecyclerView pictureAdapteRecyclerView = new PictureAdapteRecyclerView(buidpictures(),R.layout.cradview_picture,getActivity());
        picturesRecycler.setAdapter(pictureAdapteRecyclerView);

        return view;
    }

    public ArrayList<Picture> buidpictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add( new Picture("http://fondos.para-celulares.com/Fondos/174_132/paisaje/palm-leaf.jpg", "Hawerd Gonzalez", "4 Dias", "3 Me Gusta" ));
        pictures.add( new Picture("http://fondos.para-celulares.com/Fondos/174_132/paisaje/fofpoppys.jpg", "Victor Gutierrez", "5 Dias", "11 Me Gusta"));
        pictures.add( new Picture("http://fondos.para-celulares.com/Fondos/174_132/paisaje/poppy-moon.jpg", "Steiner Sanchez", "8 Dias", "15 Me Gusta"));

        return pictures;
    }

    public  void showToolbar(String tittle, boolean upbutton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);                                                               //Crea la compatibilidad con versiones anteriores a lolipop
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upbutton);
    }

}
