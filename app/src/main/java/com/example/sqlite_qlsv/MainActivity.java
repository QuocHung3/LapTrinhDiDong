package com.example.sqlite_qlsv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.sqlite_qlsv.adapter.SinhVienAdapter;
import com.example.sqlite_qlsv.dao.SinhVienDao;
import com.example.sqlite_qlsv.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<SinhVien> sinhVienList;
    private ListView lvSinhVien;
    private SinhVienAdapter adapter;
    private SinhVienDao svDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSinhVien = findViewById(R.id.lv_sinhvien_154);
        svDao = new SinhVienDao(MainActivity.this);


        sinhVienList = new ArrayList<SinhVien>();
        sinhVienList = svDao.TatCaSinhVien();


        adapter = new SinhVienAdapter(getApplicationContext(),sinhVienList);
        lvSinhVien.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_them){
            Intent intent =new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);
        }
        if(id == R.id.menu_thoat) {
            finish();
        }

        return true;
    }
}