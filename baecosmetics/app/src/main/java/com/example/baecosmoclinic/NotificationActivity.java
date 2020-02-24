package com.example.baecosmoclinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.douglas.baecosmoclinic.adapter.NotificationRecyclerAdapter;
import com.douglas.baecosmoclinic.adapter.RecyclerViewAdapter;
import com.douglas.bean.Service;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Service> serviceList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        getIds();

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


        NotificationRecyclerAdapter myAdapter = new NotificationRecyclerAdapter(this,serviceList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }

    public void getIds()
    {
        recyclerView = findViewById(R.id.recyclerView);

    }

}
