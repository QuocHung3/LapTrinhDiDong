package com.example.ltdd_gk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailSubjectActivity extends AppCompatActivity {
    private ImageView img_lv_item_detail;
    private TextView name_lv_item_detail,desc_lv_item_detail;
    private Button button_back_list_subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_subject);

        img_lv_item_detail = (ImageView) findViewById(R.id.img_lv_item_detail);
        name_lv_item_detail = (TextView) findViewById(R.id.name_lv_item_detail);
        desc_lv_item_detail = (TextView) findViewById(R.id.desc_lv_item_detail);
        button_back_list_subject = (Button) findViewById(R.id.button_back_list_subject);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        name_lv_item_detail.setText(bundle.getString("name"));
        desc_lv_item_detail.setText(bundle.getString("desc"));
        if(bundle != null) {
            name_lv_item_detail.setText(bundle.getString("name"));
            desc_lv_item_detail.setText(bundle.getString("desc"));
            img_lv_item_detail.setImageResource(bundle.getInt("img"));
        }

        button_back_list_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}