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

import java.util.HashMap;
import java.util.Map;


public class MainActivity3 extends AppCompatActivity
{


    private EditText usernameEditText, passwordEditText,GenerEditText, gmailEditText;
    private Button loginButton;
    private FirebaseFirestore mfirestore;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        usernameEditText = findViewById(R.id.editTextTextPersonName3);
        passwordEditText = findViewById(R.id.editTextTextPersonName4);
        GenerEditText = findViewById(R.id.editTextTextPersonName7);
        gmailEditText = findViewById(R.id.editTextTextPersonName5);
        loginButton = findViewById(R.id.button4);

        mAuth = FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String Genero = GenerEditText.getText().toString();
                String Gmail = gmailEditText.getText().toString();

                postUser(username,password,Genero,Gmail);
            }
        });
    }

    private void postUser(String username, String password, String genero, String gmail)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("Usuario",username);
        map.put("Contraseña",password);
        map.put("Genero",genero);
        map.put("Gmail",gmail);
        mfirestore.collection("Usuarios").add(map);
        Intent Volver= new Intent(this,MainActivity2.class);
        startActivity(Volver);
    }


}
