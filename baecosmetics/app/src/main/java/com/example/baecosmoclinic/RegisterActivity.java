package com.example.baecosmoclinic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText email,password,confirmPassword;
    private Button registration;
    private TextView validationText;
    private RelativeLayout relativeLayout;

    private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener firebaseAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance(); // get current state of the login state

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//whenever user logs in, this will be called
                if (user != null){
                    mAuth.signOut();

//                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
//                    startActivity(intent);
//                    finish();
                    //return;
                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }

//        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//whenever user logs in, this will be called
//                if (user != null){
//                    mAuth.signOut();
////                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
////                    startActivity(intent);
////                    finish();
//                    //return;
//                }
//                else
//                {
//
//                }
//            }
//        };

        email = findViewById(R.id.emailFromRegister);
        password = findViewById(R.id.passwordFromRegister);
        confirmPassword = findViewById(R.id.confirmPasswordFromRegister);
        registration = findViewById(R.id.registration);
        validationText = findViewById(R.id.invalidRegisterText);
        relativeLayout = findViewById(R.id.relativeLayout);




        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userEmail = email.getText().toString();
                final String userPassword = password.getText().toString();
                final String userConfirmPassword = confirmPassword.getText().toString();
                if (userEmail.isEmpty() || userPassword.isEmpty() || userConfirmPassword.isEmpty())
                {
                    validationText.setText("Please fill all required fields.");
                }
                else if(userPassword.trim().length()<6)
                {validationText.setText("Please enter a password of at least 6 characters.");}
                else{
                    if (userPassword.equals(userConfirmPassword)) {
                        mAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    validationText.setText(""+task.getException().getMessage());
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    System.out.println("==================="+task.getException());
                                }
                                else {
                                    Toast.makeText(RegisterActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                                    mAuth.signOut();
                                    validationText.setText("Registration successful. Go back to login page to login");
                                    validationText.setTextColor(Color.GREEN);
                                }
//                          else {
//                          String userID = mAuth.getCurrentUser().getUid();
//                          DatabaseReference currentUserDB = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(userID);
//                          currentUserDB.setValue(true);
//                          }
                            }
                        });
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
                        validationText.setText("Passwords don't match!");
                        validationText.setTextColor(Color.RED);
                    }
                }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        //mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //mAuth.removeAuthStateListener(firebaseAuthListener);

    }
}
