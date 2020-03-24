package com.example.baecosmoclinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.os.Bundle;
import android.widget.Toast;

import com.douglas.baecosmoclinic.adapter.NotificationRecyclerAdapter;
import com.douglas.baecosmoclinic.adapter.RecyclerViewAdapter;
import com.douglas.bean.NotificationList;
import com.douglas.bean.Service;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Service> serviceList;
    List<NotificationList>  listOfNotification;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


      //  getIds();

        serviceList = new ArrayList<>();
        serviceList.add(new Service("Notification 1","Categorie Service","Description book",R.drawable.thevigitarian));
        serviceList.add(new Service("Notification 2","Categorie Service","Description book",R.drawable.thewildrobot));
        serviceList.add(new Service("Notification 3","Categorie Service","Description book",R.drawable.mariasemples));
        serviceList.add(new Service("Notification 4","Categorie Service","Description book",R.drawable.themartian));
        serviceList.add(new Service("Notification 5","Categorie Service","Description book",R.drawable.hediedwith));
        serviceList.add(new Service("Notification 6","Categorie Service","Description book",R.drawable.thevigitarian));
        serviceList.add(new Service("The Wild Robot","Categorie Service","Description book",R.drawable.thewildrobot));
        serviceList.add(new Service("Maria Semples","Categorie Service","Description book",R.drawable.mariasemples));
        serviceList.add(new Service("The Martian","Categorie Service","Description book",R.drawable.themartian));
        serviceList.add(new Service("He Died with...","Categorie Service","Description book",R.drawable.hediedwith));
        serviceList.add(new Service("The Vegitarian","Categorie Service","Description book",R.drawable.thevigitarian));
        serviceList.add(new Service("The Wild Robot","Categorie Service","Description book",R.drawable.thewildrobot));
        serviceList.add(new Service("Maria Semples","Categorie Service","Description book",R.drawable.mariasemples));
        serviceList.add(new Service("The Martian","Categorie Service","Description book",R.drawable.themartian));
        serviceList.add(new Service("He Died with...","Categorie Service","Description book",R.drawable.hediedwith));

        recyclerView = findViewById(R.id.recyclerView);
        //NotificationRecyclerAdapter myAdapter = new NotificationRecyclerAdapter(this,serviceList);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setAdapter(myAdapter);




        db = FirebaseDatabase.getInstance().getReference().child("notification");

        listOfNotification = new ArrayList<>();

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String title = snapshot.child("title").getValue(String.class);
                    String desc = snapshot.child("description").getValue(String.class);

                    listOfNotification.add(new NotificationList(title, desc));

                }
                NotificationRecyclerAdapter myAdapter = new NotificationRecyclerAdapter(NotificationActivity.this, listOfNotification);
                recyclerView.setLayoutManager(new LinearLayoutManager(NotificationActivity.this));
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
