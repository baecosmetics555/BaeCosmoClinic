package com.example.baecosmoclinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.douglas.baecosmoclinic.adapter.RecyclerViewAdapter;
import com.douglas.bean.ServiceCategory;
import com.douglas.bean.ServiceDetail;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ServiceDetailActivity extends AppCompatActivity {

    List<ServiceDetail> serviceList;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);


        Intent i = getIntent();
        final String category = i.getStringExtra("Category");
        Toast.makeText(this, ""+category, Toast.LENGTH_SHORT).show();

        db = FirebaseDatabase.getInstance().getReference();

        db.keepSynced(true);




        db.child("Service").child(category).addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot2 : dataSnapshot.getChildren()) {


                        Toast.makeText(ServiceDetailActivity.this, snapshot2.child("title").getValue(String.class), Toast.LENGTH_SHORT).show();

                        String title = snapshot2.child("title").getValue(String.class);
                        Toast.makeText(ServiceDetailActivity.this, "" + title, Toast.LENGTH_SHORT).show();
                        //String thumbnail = snapshot2.child("url").getValue(String.class);

                        String description = "";
                        if (snapshot2.child("description").exists()) {
                            description = snapshot2.child("description").getValue(String.class);
                            Toast.makeText(ServiceDetailActivity.this, "" + description, Toast.LENGTH_SHORT).show();
                        } else {
                            description = "";
                        }

                        //serviceList.add(new ServiceDetail(title,category,description,thumbnail));

                    }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
