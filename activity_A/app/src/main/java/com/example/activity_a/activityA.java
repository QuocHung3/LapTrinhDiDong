package com.example.activity_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activityA extends AppCompatActivity {
    EditText title,description;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        title = (EditText) findViewById(R.id.title);
        description = (EditText) findViewById(R.id.description);
        sendBtn = (Button) findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activityA.this,activityB.class);

                Bundle bundle = new Bundle();
                bundle.putString("title",title.getText().toString());
                bundle.putString("description",description.getText().toString());
                intent.putExtra("dataCalled",bundle);

                startActivity(intent);

            }
        });
    }
}