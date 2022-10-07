package com.example.ltdd_gk;

import static com.example.ltdd_gk.R.layout.signin_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    EditText name_signin,pass_signin;
    Button button_signin;
    TextView link_to_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(signin_activity);

        name_signin = (EditText) findViewById(R.id.name_signin);
        pass_signin = (EditText) findViewById(R.id.pass_signin);
        button_signin = (Button) findViewById(R.id.button_signin);
        link_to_signup = (TextView) findViewById(R.id.link_to_signup);

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name_signin.getText().toString().trim().equals("") ||
                pass_signin.getText().toString().trim().equals("")) {
                    Toast.makeText(SigninActivity.this,"Nhập tất cả các trường!",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(name_signin.getText().toString().trim().equals("abc123") ||
                        pass_signin.getText().toString().trim().equals("123")) {
                    Toast.makeText(SigninActivity.this,"Nhập tất cả các trường!",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}