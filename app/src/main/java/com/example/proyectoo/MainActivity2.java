package com.example.proyectoo;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity2 extends AppCompatActivity
{


    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private FirebaseFirestore mfirestore;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Obtener referencias de los elementos de la interfaz
        usernameEditText = findViewById(R.id.Login);
        passwordEditText = findViewById(R.id.Contraseña);
        loginButton = findViewById(R.id.button);

        mAuth = FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                postUser(username,password);
            }
        });
    }

    public void postUser(String username, String password)
    {

        Intent Seguir = new Intent(this,MainActivity5.class);
        startActivity(Seguir);
    }

    public void Registros(View view)
    {
        Intent Regist=new Intent(this, MainActivity3.class);
        startActivity(Regist);
    }
}
