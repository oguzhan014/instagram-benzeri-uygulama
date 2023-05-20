package com.oguzhann.loginanime;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Searchfrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Searchfrag extends Fragment {

    private EditText searchEditText;
    private RecyclerView searchResultsRecyclerView;
    private List<String> searchResults;
    private SearchResultAdapter searchResultAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_searchfrag, container, false);


        // Gerekli bileşenleri tanımla
        searchEditText = view.findViewById(R.id.searchEditText);
        searchResultsRecyclerView = view.findViewById(R.id.searchResultsRecyclerView);

        // RecyclerView için düzen yöneticisi ayarla
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        searchResultsRecyclerView.setLayoutManager(layoutManager);

        // Arama sonuçlarını tutacak liste oluştur
        searchResults = new ArrayList<>();

        // RecyclerView için adaptör oluştur ve ayarla
        searchResultAdapter = new SearchResultAdapter(searchResults);
        searchResultsRecyclerView.setAdapter(searchResultAdapter);

        return view;
    }

}