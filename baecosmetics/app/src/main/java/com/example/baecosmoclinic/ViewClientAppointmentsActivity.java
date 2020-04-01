package com.example.baecosmoclinic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.bean.Appointment;
import com.bean.TimeSlots;
import com.douglas.baecosmoclinic.adapter.ScheduleRecyclerAdapter;
import com.douglas.bean.Service;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewClientAppointmentsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Service> serviceList ;
    String day = "";


Boolean empty = true;
String usn="";

    FirebaseDatabase mDatabase;
    DatabaseReference mDatabaseReference;
    Appointment appointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_client_appointments);
        getIds();

          mDatabase = FirebaseDatabase.getInstance();
         mDatabaseReference = mDatabase.getReference();


        SharedPreferences sp = getSharedPreferences("userinfo" , Context.MODE_PRIVATE);
        String email  = sp.getString("email","null");
        usn=  email.trim().split("@")[0];

        initTab1();



        getData();
    }



    private void initTab1() {

        recyclerView.setVisibility(View.VISIBLE);




    }

    public void getIds()
    {
        recyclerView = findViewById(R.id.recyclerView);



    }



    public void getData()
    {
        mDatabaseReference = mDatabase.getReference().child("appointment").child("days");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            TimeSlots friday =    dataSnapshot.child("friday").child("timeslots").getValue(TimeSlots.class);
                TimeSlots monday =    dataSnapshot.child("monday").child("timeslots").getValue(TimeSlots.class);
                TimeSlots tuesday =    dataSnapshot.child("tuesday").child("timeslots").getValue(TimeSlots.class);
                TimeSlots wednesday =    dataSnapshot.child("wednesday").child("timeslots").getValue(TimeSlots.class);
                TimeSlots thursday =    dataSnapshot.child("thursday").child("timeslots").getValue(TimeSlots.class);

                TimeSlots booking=null;

                if(friday.getUsername().equals(usn))
                {empty = false;
                    booking = friday;}
                else if(monday.getUsername().equals(usn))
                {empty = false;
                    booking = monday;}
                else if(tuesday.getUsername().equals(usn))
                {empty = false;
                    booking = tuesday;}
                else if(wednesday.getUsername().equals(usn))
                {empty = false;
                    booking = wednesday;}
                else if(thursday.getUsername().equals(usn))
                {empty = false;
                    booking = thursday;}



              //  appointment = dataSnapshot.getValue(Appointment.class);

             //   Log.d(TAG, "User name: " + ds.getName() + ", email " + ds.getEmail());

               // System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + friday.getTime());

                serviceList = new ArrayList<>();
                serviceList.add(new Service("Current Appointment",booking.getDate() + " "  + booking.getTime() + "\n\n" +"username: " + booking.getUsername()  ,"",R.drawable.thevigitarian));
                /*serviceList.add(new Service("Tuesday",tuesday.getDate() + " "  + tuesday.getTime() + "\n\n" +"username: "+ tuesday.getUsername() ,"Description book",R.drawable.thewildrobot));
                serviceList.add(new Service("Wednesday",wednesday.getDate() + " "  + wednesday.getTime() + "\n\n" +"username: "+ wednesday.getUsername() ,"Description book",R.drawable.mariasemples));
                serviceList.add(new Service("Thursday",thursday.getDate() + " "  + thursday.getTime() + "\n\n" +"username: "+ thursday.getUsername() ,"Description book",R.drawable.themartian));
                serviceList.add(new Service("Friday",friday.getDate() + " "  + friday.getTime() + "\n\n" +"username: "+ friday.getUsername() ,"Description book",R.drawable.hediedwith));
*/

                ScheduleRecyclerAdapter myAdapter = new ScheduleRecyclerAdapter(ViewClientAppointmentsActivity.this,serviceList);
                recyclerView.setLayoutManager(new LinearLayoutManager(ViewClientAppointmentsActivity.this));
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
             //   Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

}
