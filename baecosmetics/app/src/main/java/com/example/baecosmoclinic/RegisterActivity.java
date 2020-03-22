package com.example.baecosmoclinic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance(); // get current state of the login state

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//whenever user logs in, this will be called
                if (user != null){
                    mAuth.signOut();
//                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
//                    startActivity(intent);
//                    finish();
                    return;
                }
                else
                {

                }
            }
        };

        email = findViewById(R.id.emailFromRegister);
        password = findViewById(R.id.passwordFromRegister);
        confirmPassword = findViewById(R.id.confirmPasswordFromRegister);
        registration = findViewById(R.id.registration);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userEmail = email.getText().toString();
                final String userPassword = password.getText().toString();
                final String userConfirmPassword = confirmPassword.getText().toString();
                if (userPassword.equals(userConfirmPassword)) {
                    mAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {


                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Sign Up Error", Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText(RegisterActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();

//                          else {
//                          String userID = mAuth.getCurrentUser().getUid();
//                          DatabaseReference currentUserDB = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(userID);
//                          currentUserDB.setValue(true);
//                          }
                        }
                    });
                }
                else
                    Toast.makeText(RegisterActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
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
