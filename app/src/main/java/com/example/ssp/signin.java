package com.example.ssp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signin extends AppCompatActivity {
    EditText signin_acc,signin_pass;
    Button signin_btn;
    TextView signup_tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        signin_acc = (EditText) findViewById(R.id.signin_acc);
        signin_pass = (EditText) findViewById(R.id.signin_pass);
        signin_btn = (Button) findViewById(R.id.signin_btn);
        signup_tv = (TextView) findViewById(R.id.signup_tv);

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signin_acc.getText().toString().trim().equals("") || signin_pass.getText().toString().trim().equals("")) {
                    Toast.makeText(signin.this,"Nhập tất cả các trường",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(signin_acc.getText().toString().trim().equals("nqhung") || signin_pass.getText().toString().trim().equals("123")) {
                    Intent intent = new Intent(signin.this,profile.class);
                    startActivity(intent);
                }
            }
        });

        signup_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signin.this,signup.class);
                startActivity(intent);
            }
        });
    }
}