package com.example.baecosmoclinic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.douglas.baecosmoclinic.adapter.RecyclerViewAdapter;
import com.douglas.baecosmoclinic.adapter.ScheduleRecyclerAdapter;
import com.douglas.bean.Service;
import com.fragments.FragmentOne;
import com.fragments.FragmentThree;
import com.fragments.FragmentTwo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends FragmentActivity implements FragmentOne.OnFragmentInteractionListener, FragmentTwo.OnFragmentInteractionListener, FragmentThree.OnFragmentInteractionListener {
    List<Service> serviceList ;
    BottomNavigationView bottomNavigation;
    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    ImageView notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_main);

        // bae cosmo clinic
        //asdfsdfsa/
        //sdfsfs
        // auhdiahdoiaoij
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        getIds();
        addListeners();

        //#4585F3
        /*Toolbar customToolBar = findViewById(R.id.toolbar);
        customToolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));*/
        serviceList = new ArrayList<>();
        serviceList.add(new Service("The Vegitarian","Categorie Service","Description book",R.drawable.thevigitarian));
        serviceList.add(new Service("The Wild Robot","Categorie Service","Description book",R.drawable.thewildrobot));
        serviceList.add(new Service("Maria Semples","Categorie Service","Description book",R.drawable.mariasemples));
        serviceList.add(new Service("The Martian","Categorie Service","Description book",R.drawable.themartian));
        serviceList.add(new Service("He Died with...","Categorie Service","Description book",R.drawable.hediedwith));
        serviceList.add(new Service("The Vegitarian","Categorie Service","Description book",R.drawable.thevigitarian));
        serviceList.add(new Service("The Wild Robot","Categorie Service","Description book",R.drawable.thewildrobot));
        serviceList.add(new Service("Maria Semples","Categorie Service","Description book",R.drawable.mariasemples));
        serviceList.add(new Service("The Martian","Categorie Service","Description book",R.drawable.themartian));
        serviceList.add(new Service("He Died with...","Categorie Service","Description book",R.drawable.hediedwith));
        serviceList.add(new Service("The Vegitarian","Categorie Service","Description book",R.drawable.thevigitarian));
        serviceList.add(new Service("The Wild Robot","Categorie Service","Description book",R.drawable.thewildrobot));
        serviceList.add(new Service("Maria Semples","Categorie Service","Description book",R.drawable.mariasemples));
        serviceList.add(new Service("The Martian","Categorie Service","Description book",R.drawable.themartian));
        serviceList.add(new Service("He Died with...","Categorie Service","Description book",R.drawable.hediedwith));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,serviceList);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        break;
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(HomeActivity.this, ScheduleActivity.class));
                        break;
                    case R.id.navigation_map:
                        startActivity(new Intent(HomeActivity.this, MapsActivity.class));
                        break;
                    case R.id.navigation_about:
                        startActivity(new Intent(HomeActivity.this, BaeProfile.class));
                        break;

                }



                return false;
            }
        });

    }

    public void getIds()
    {
        bottomNavigation = findViewById(R.id.bottomNavBar);
        notification = findViewById(R.id.notification);
    }

    public void addListeners()
    {
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, NotificationActivity.class));
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0)
            {
                return new FragmentOne();
            }
            else if (position == 1)
            {
                return new FragmentTwo();
            }
            else
            {
                return new FragmentThree();

            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
