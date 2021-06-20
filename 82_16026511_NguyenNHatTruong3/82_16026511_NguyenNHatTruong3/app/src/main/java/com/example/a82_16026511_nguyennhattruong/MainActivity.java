package com.example.a82_16026511_nguyennhattruong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button click;
    EditText textuser, textpass;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth=FirebaseAuth.getInstance();

        textuser = findViewById(R.id.email);
        textpass = findViewById(R.id.pass);
        click = findViewById(R.id.btn_login);

        click.setOnClickListener(v -> xacthuc());
    }

    private void xacthuc() {
        String email = textuser.getText().toString();
        String pass = textpass.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Toast.makeText(this, "incorect", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, ListProductActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}