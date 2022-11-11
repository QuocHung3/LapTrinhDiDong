package com.example.quanlysinhvien_sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.quanlysinhvien_sqlite.adapter.LopAdapter;
import com.example.quanlysinhvien_sqlite.adapter.SinhvienAdapter;
import com.example.quanlysinhvien_sqlite.dao.LopDao;
import com.example.quanlysinhvien_sqlite.dao.SinhvienDao;
import com.example.quanlysinhvien_sqlite.model.Lop;
import com.example.quanlysinhvien_sqlite.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvlop;
    private List<Lop> lopList ;
    private List<Sinhvien> sinhvienList;
    private LopAdapter adapter;
    private LopDao dao;
    private SinhvienDao svdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvlop = (ListView) findViewById(R.id.lv_lop);

        lopList = new ArrayList<Lop>();
        dao = new LopDao(MainActivity.this);
        lopList = dao.getALL();
        adapter = new LopAdapter(getApplicationContext(), lopList);
        lvlop.setAdapter(adapter);
        lvlop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ListsvActivity.class);
                startActivity(intent);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.them)
        {
            Intent intent = new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);

        }
        if(id == R.id.thoat)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}