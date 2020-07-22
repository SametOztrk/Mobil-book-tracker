package com.example.lbrary;


import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {


    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    KitapEkleAdapter db;

    ListView lv;

    public Frag2() {

    }

    /* update fragment after adding new data */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);

        // Refresh tab data:

        if (getFragmentManager() != null) {

            getFragmentManager()
                    .beginTransaction()
                    .detach(this)
                    .attach(this)
                    .commit();
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_frag2, container, false);

        db= new KitapEkleAdapter(getActivity());

        lv=(ListView) view.findViewById(R.id.listview);

         list = new ArrayList<>();

        Cursor cursor=db.viewData();

        if(cursor.getCount()==0)
        {
            Toast.makeText(getActivity(),"no data",Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                list.add(cursor.getString(1));

                adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,list);
                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }



        }


        // Inflate the layout for this fragment
        return view;
    }



}
