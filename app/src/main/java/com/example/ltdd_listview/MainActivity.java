package com.example.ltdd_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView theLV;
    ArrayList<The> arrThe;
    theAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        adapter = new theAdapter(MainActivity.this,R.layout.dong_the,arrThe);
        theLV.setAdapter(adapter);
    }

    private void anhXa() {
        theLV  = (ListView) findViewById(R.id.theLV);
        arrThe =new ArrayList<>();

        arrThe.add(new The("Sinh nhật",R.drawable.gift));
        arrThe.add(new The("Giải trí",R.drawable.giaitri));
        arrThe.add(new The("Nhà giáo Việt Nam",R.drawable.nhagiaovn));
        arrThe.add(new The("Chào buổi sáng",R.drawable.goodmorning));
        arrThe.add(new The("Chúc mừng năm mới",R.drawable.newyear));
        arrThe.add(new The("Valentines",R.drawable.valentines));
    }
}