package com.example.ltdd_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details_TG extends AppCompatActivity {
    TextView tenTG_det,motaTg_det;
    ImageView imgTG_det;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_tg);

        tenTG_det = findViewById(R.id.tenThe_det);
        motaTg_det = findViewById(R.id.motaThe_det);
        imgTG_det = findViewById(R.id.imgThe_det);

        Bundle data = getIntent().getExtras();

        String title = data.getString("tenTG");
        String desc = data.getString("motaTG");
        Integer img = data.getInt("imgTG");

        tenTG_det.setText(title.toString());
        motaTg_det.setText(desc.toString());
        imgTG_det.setImageResource(img);

    }


}