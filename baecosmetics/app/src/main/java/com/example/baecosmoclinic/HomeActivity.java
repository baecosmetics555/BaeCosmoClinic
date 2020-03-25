package com.example.baecosmoclinic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.douglas.baecosmoclinic.adapter.NotificationRecyclerAdapter;
import com.douglas.baecosmoclinic.adapter.RecyclerViewAdapter;
import com.douglas.baecosmoclinic.adapter.ScheduleRecyclerAdapter;
import com.douglas.bean.NotificationList;
import com.douglas.bean.Service;
import com.douglas.bean.ServiceCategory;
import com.douglas.bean.ServiceDetail;
import com.fragments.FragmentOne;
import com.fragments.FragmentThree;
import com.fragments.FragmentTwo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends FragmentActivity implements FragmentOne.OnFragmentInteractionListener, FragmentTwo.OnFragmentInteractionListener, FragmentThree.OnFragmentInteractionListener {
    List<ServiceDetail> serviceList;
    List<ServiceCategory> serviceCategory;
    BottomNavigationView bottomNavigation;
    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    ImageView notification;
    RecyclerView recyclerView;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_main);


        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        getIds();
        addListeners();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        serviceList = new ArrayList<>();
        serviceCategory = new ArrayList<>();

        db = FirebaseDatabase.getInstance().getReference().child("Service");

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    final String category= snapshot.getKey();


                    db.child(category).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot snapshot2 : dataSnapshot.getChildren()) {

                                String title = snapshot2.child("title").getValue(String.class);
                                String thumbnail = snapshot2.child("url").getValue(String.class);
                                serviceList.add(new ServiceDetail(title,category,"Description",thumbnail));

                                if(thumbnail!=null) {
                                    serviceCategory.add(new ServiceCategory(category,thumbnail));
                                }
                                //

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }

                RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(HomeActivity.this, serviceCategory);
                recyclerView.setLayoutManager(new GridLayoutManager(HomeActivity.this,2));
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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
                    case R.id.navigation_account:
                        startActivity(new Intent(HomeActivity.this,UserProfile.class));
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

    // notification action
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
