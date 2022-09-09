package com.example.activity_a;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class activityB extends AppCompatActivity {
    TextView titleView,descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        // Anh Xa
        titleView = (TextView) findViewById(R.id.rsTitle);
        descriptionView = (TextView) findViewById(R.id.rsDescription);

        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra("dataCalled");

        titleView.setText(data.getString("title"));
        descriptionView.setText(data.getString("description"));
    }
}
