package com.example.sqlite_qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class ListSach extends AppCompatActivity {
    private Spinner maTG;
    private EditText tenTG,tenSach,ngayXB;
    private Button btn_themSach;
    private ListView lv_sach;
    ArrayAdapter spinnerAdapter;
    ArrayList<Sach> dsSach = new ArrayList<>();
    ArrayList<String> dsMaTG = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sach);

        maTG = findViewById(R.id.maTG);
        tenTG = findViewById(R.id.tenTG);
        tenSach = findViewById(R.id.tenSach);
        ngayXB = findViewById(R.id.ngayXB);
        btn_themSach = findViewById(R.id.btn_themSach);

        lv_sach= findViewById(R.id.lv_Sach);

        dsSach = SachDao.getAllSach(ListSach.this);
        for(Sach sach: dsSach){
            dsMaTG.add(sach.getMaTG());
        }

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,dsMaTG);
        maTG.setAdapter(spinnerAdapter);
    }
}