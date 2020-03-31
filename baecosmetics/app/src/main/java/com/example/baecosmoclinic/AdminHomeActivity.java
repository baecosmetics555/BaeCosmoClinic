package com.example.baecosmoclinic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.AppCompatActivity;

public class AdminHomeActivity extends AppCompatActivity {

    private ImageView logout;

    private FirebaseAuth mAuth;

    Button postSchedule, viewAppointments, postNotitification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        //getActionBar().hide();

        logout = findViewById(R.id.logout);

        mAuth = FirebaseAuth.getInstance();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//whenever user logs in, this will be called
                if (user != null){
                    mAuth.signOut();
                    Intent intent = new Intent(AdminHomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
                //mAuth.signOut();
            }
        });

        getIds();
        setListeners();
    }


  public void getIds()
    {
        viewAppointments = findViewById(R.id.viewAppointments);
        postSchedule = findViewById(R.id.postSchedule);
        postNotitification = findViewById(R.id.sendNotifications);
    }

    public void setListeners(){

        viewAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AdminHomeActivity.this, ViewAppointmentsActivity.class));

            }
        });
    }
}
