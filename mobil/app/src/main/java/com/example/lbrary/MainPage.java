package com.example.lbrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class MainPage extends AppCompatActivity {

    Toolbar tb;
    ViewPager vp;
    TabLayout tl;

    private FragmentAdapter fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        tb=findViewById(R.id.main_page);
        setSupportActionBar(tb);

        vp=findViewById(R.id.ana_sekme_pager);

        fa=new FragmentAdapter(getSupportFragmentManager());

        vp.setAdapter(fa);

        tl=findViewById(R.id.ana_sekmeler);
        tl.setupWithViewPager(vp);

    }
}
