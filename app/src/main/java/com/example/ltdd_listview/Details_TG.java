package com.example.ltdd_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Details_TG extends AppCompatActivity {
    TextView tenTG_det,motaTg_det;
    ImageView imgTG_det;
    ListView lv_tacpham;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_tg);

        tenTG_det = findViewById(R.id.tenThe_det);
        motaTg_det = findViewById(R.id.motaThe_det);
        imgTG_det = findViewById(R.id.imgThe_det);
        lv_tacpham = findViewById(R.id.lv_tacpham);

        Bundle data = getIntent().getExtras();

        String title = data.getString("tenTG");
        String desc = data.getString("motaTG");
        Integer img = data.getInt("imgTG");

        tenTG_det.setText(title.toString());
        motaTg_det.setText(desc.toString());
        imgTG_det.setImageResource(img);

        List<String> listTP = new ArrayList<>();

        listTP.add("Buổi học cuối cùng");
        listTP.add("Con Đường");
        listTP.add("Ông cò");
        listTP.add("Thương vợ");
        listTP.add("Phường thơ");
        listTP.add("Vịnh khoa thi hương");

        ArrayAdapter adap  = new ArrayAdapter(Details_TG.this, android.R.layout.simple_list_item_1,listTP);
        lv_tacpham.setAdapter(adap);
    }


}