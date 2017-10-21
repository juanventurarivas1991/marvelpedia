package com.juan.marvelpedia;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


//Activity que muestra las dos pestañas para buscar personajes y comics

public class CharactersComics extends AppCompatActivity {


    TabLayout customTabLayout;
    ViewPager viewPager;
    MyPagerAdapter adapter;

    @Override
    //Metodo onCreate que inicializa la clase
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);


        customTabLayout = (TabLayout) findViewById(R.id.customTabLayout);
        customTabLayout.setBackgroundResource(R.color.primaryColor);

        customTabLayout.setTabMode(TabLayout.MODE_FIXED);


        String personaje = "BUSCAR PERSONAJE";
        String comic = "BUSCAR COMIC";


        viewPager = (ViewPager) findViewById(R.id.MiViewpager);

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);


        customTabLayout.setupWithViewPager(viewPager);

        customTabLayout.getTabAt(0).setText(personaje);
        customTabLayout.getTabAt(1).setText(comic);
        customTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#000000"));


        customTabLayout.setSelectedTabIndicatorHeight(18);

        customTabLayout.setTabTextColors(ColorStateList.valueOf(Color.WHITE));


    }

    //Clase adaptador que controla el paso de una pestaña a otra deslizando
    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int pos) {
            FragmentControlador f = new FragmentControlador();
            Bundle args = new Bundle();
            args.putInt("pos", pos);
            f.setArguments(args);

            return f;

        }

        @Override
        public int getCount() {
            return 2;
        }

    }
}
