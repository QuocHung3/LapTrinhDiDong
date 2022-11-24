package com.example.bkt2_qlthuocnam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference ref;
    private TextView rs_acc,rs_pass;
    private EditText et_acc,et_pass;
    private Button btn_login,btn_showrs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref = FirebaseDatabase.getInstance().getReference();

        et_acc = findViewById(R.id.et_acc);
        et_pass = findViewById(R.id.et_pass);
        rs_acc = findViewById(R.id.rs_acc);
        rs_pass = findViewById(R.id.rs_pass);

        btn_login = findViewById(R.id.btn_login);
        btn_showrs = findViewById(R.id.btn_showrs);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account acc = new Account(et_acc.getText().toString(),et_pass.getText().toString());
                ref.child("account").child(acc.getAcc()).setValue(acc);
            }
        });

        btn_showrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData(et_acc.getText().toString());
            }
        });
    }

    private void getData(String acc) {
        ref.child("account").child(acc).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()) {
                    if(task.getResult().exists()) {
                        DataSnapshot dataSnapshot = task.getResult();

                        String account = String.valueOf(dataSnapshot.child("acc").getValue());
                        String password = String.valueOf(dataSnapshot.child("pass").getValue());

                        rs_acc.setText(account);
                        rs_pass.setText((password));
                    } else {
                        Toast.makeText(MainActivity.this, "Account does't exist", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "failed to read", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}