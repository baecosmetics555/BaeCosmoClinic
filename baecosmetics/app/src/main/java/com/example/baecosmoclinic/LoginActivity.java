package com.example.baecosmoclinic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText email,password;
    private Button login,registration;
    private TextView invalidLogin;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance(); // get current state of the login state

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//whenever user logs in, this will be called
                if (user != null){
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);
        registration = findViewById(R.id.registration);
        invalidLogin = findViewById(R.id.invalidLoginText);

//        registration.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final String userEmail = email.getText().toString();
//                final String userPassword = password.getText().toString();
//                mAuth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(!task.isSuccessful()){
//                            Toast.makeText(LoginActivity.this,"Sign Up Error", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            String userID = mAuth.getCurrentUser().getUid();
//                            DatabaseReference currentUserDB = FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers").child(userID);
//                            currentUserDB.setValue(true);
//                        }
//                    }
//                });
//            }
//        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userEmail = email.getText().toString();
                final String userPassword = password.getText().toString();
                mAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            invalidLogin.setText("Please enter a valid email or password. \nIf you are a new user, please register");
                            Toast.makeText(LoginActivity.this,"Sign In Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                //finish();
                return;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);

    }
}

