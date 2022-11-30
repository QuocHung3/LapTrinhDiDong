package com.example.ltdd_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView tgLV;
    ArrayList<TacGia> arrThe;
    theAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        adapter = new theAdapter(MainActivity.this,R.layout.dong_the,arrThe);
        tgLV.setAdapter(adapter);

        tgLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Details_TG.class);
                Bundle bundle =  new Bundle();
                bundle.putInt("imgTG",arrThe.get(i).getImgTG());
                bundle.putString("tenTG",arrThe.get(i).getTenTG());
                bundle.putString("motaTG",arrThe.get(i).getMotaTG());

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void anhXa() {
        tgLV  = (ListView) findViewById(R.id.theLV);
        arrThe = new ArrayList<>();
        arrThe.add(new TacGia("Đồng Kiên Cương","Đồng Kiên Cương được nhận định là người có phong thái siêu thoát, ông xứng đáng được gọi là người không lường. ",R.drawable.tuannguyen));
        arrThe.add(new TacGia("Nguyễn Tuân","Nguyễn Tuân có sở trường về tùy bút và ký. Ông viết văn với một phong cách tài hoa uyên bác và được xem là bậc thầy trong việc sáng tạo và sử dụng tiếng ...", R.drawable.tuannguyen));

    }
}