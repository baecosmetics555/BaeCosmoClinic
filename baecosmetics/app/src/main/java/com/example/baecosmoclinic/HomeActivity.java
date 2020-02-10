package com.example.baecosmoclinic;

import android.os.Bundle;
import android.view.MenuItem;

import com.douglas.baecosmoclinic.adapter.RecyclerViewAdapter;
import com.douglas.bean.Service;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {
    List<Service> serviceList ;
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_main);


        getIds();

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
                        break;
                    case R.id.navigation_notifications:
                        break;

                }



                return false;
            }
        });

    }

    public void getIds()
    {
        bottomNavigation = findViewById(R.id.bottomNavBar);
    }
}
