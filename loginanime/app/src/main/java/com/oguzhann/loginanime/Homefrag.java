package com.oguzhann.loginanime;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Homefrag#newInstance} factory method to
 * create an instance of this fragment.
 */


public class Homefrag extends Fragment {

    ListView listem1;

    private ArrayAdapter<String> adapter;
    private String [] F1Teams = {"Mercedes-AMG Petronas Formula One Team","Scuderia Ferrari ","Red Bull Racing ","McLaren F1 Team","Aston Martin  Formula One Team"};
    private String [] F1teaminformation = {"Mercedes, son yıllarda Formula 1'de büyük başarılar elde etmiş ve 2023 sezonuna da şampiyonluk hedefiyle girmektedir. Takımın pilotları Lewis Hamilton ve George Russell'dan oluşmaktadır.",
    "Ferrari, Formula 1'in en ünlü takımlarından biridir. İtalyan takımı, 2023 sezonuna yeni bir pilot kadrosuyla girmiştir. Takımın pilotları Charles Leclerc ve Robert Shwartzman'dır.",
    "Red Bull, son yıllarda Mercedes ile büyük bir rekabet içinde olan bir takım. Takımın pilotları Max Verstappen ve Sergio Perez, 2023 sezonunda da Red Bull için yarışacaklar.",
    "McLaren, Formula 1'in en eski takımlarından biri ve son yıllarda yükselişte olan bir takım. Takımın pilotları Lando Norris ve Daniel Ricciardo, takımın başarısına katkı sağlamaya çalışacaklar.",
    "Aston Martin, 2021 sezonunda Formula 1'e geri dönen bir takım. Takımın pilotları Fernando Alonso ve Lance Stroll, 2023 sezonunda da Aston Martin için yarışacaklar."};

    private  int [] F1draw = {R.drawable.toto,R.drawable.lecler,R.drawable.maxvestapen,R.drawable.londo,R.drawable.fernando};

    private Bitmap choosef1;

    static public Takimlar takimlar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_homefrag, container, false);

        listem1 = view.findViewById(R.id.listem);
        adapter= new ArrayAdapter<>(getContext() , android.R.layout.simple_list_item_1,F1Teams);
        listem1.setAdapter(adapter);

        listem1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getActivity(),MainActivity3.class);
                choosef1=BitmapFactory.decodeResource(getActivity().getResources(),F1draw[i]);
                takimlar= new Takimlar(F1Teams[i],F1teaminformation[i],choosef1);

                startActivity(intent);
            }
        });

        return view;
}

}

