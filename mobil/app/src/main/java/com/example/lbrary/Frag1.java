package com.example.lbrary;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    public Frag1() {
        // Required empty public constructor
    }

    EditText kitap_adı,yazar_adı;
    Button ekle;
    KitapEkleAdapter kitap_ekle;
    Frag2 fg2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_frag1, container, false);

            fg2=new Frag2();

        kitap_adı=view.findViewById(R.id.kitap_adı);
        yazar_adı=view.findViewById(R.id.yazar_adı);
        ekle=view.findViewById(R.id.button_add);

        kitap_ekle=new KitapEkleAdapter(getActivity());

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=kitap_adı.getText().toString();
                String s2=yazar_adı.getText().toString();

                if (s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(getActivity(),"Giriş yapınız",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Boolean check=kitap_ekle.checkBook(s1);

                    if(check==true)
                    {
                        Toast.makeText(getActivity(),"Book already exist",Toast.LENGTH_SHORT).show();
                    }
                    else {

                        Boolean addBook=kitap_ekle.addBook(s1,s2);

                        if(addBook==true)
                        {
                            Toast.makeText(getActivity(),"successfully added",Toast.LENGTH_SHORT).show();

                            fg2.adapter.notifyDataSetChanged();
                        }

                    }
                }

            }
        });



        // Inflate the layout for this fragment
        return view;

    }

}
