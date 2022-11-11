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

import com.example.quanlysinhvien_sqlite.adapter.SinhvienAdapter;
import com.example.quanlysinhvien_sqlite.dao.SinhvienDao;
import com.example.quanlysinhvien_sqlite.model.Lop;
import com.example.quanlysinhvien_sqlite.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class ListsvActivity extends AppCompatActivity {
    private ListView lvsinhvien;
    private List<Sinhvien> sinhvienList;
    private SinhvienAdapter adapter;
    private SinhvienDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvsinhvien=(ListView) findViewById(R.id.lv_sv);

        sinhvienList=new ArrayList<Sinhvien>();
        dao = new SinhvienDao(ListsvActivity.this);
        Lop lop =new Lop();
        sinhvienList = dao.getsv(lop.getMalop());


        adapter = new SinhvienAdapter(getApplicationContext(),sinhvienList);
        lvsinhvien.setAdapter(adapter);
        lvsinhvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sinhvien sv =sinhvienList.get(position);
                Intent intent=new Intent(ListsvActivity.this,EditActivity.class);
                intent.putExtra("Dulieu",sv);
                startActivity(intent);

            }
        });
        lvsinhvien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Sinhvien sv=sinhvienList.get(position);
                dao.DeleteSinhvien("" +sv.getTensv());
                return false;
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
            Intent intent = new Intent(ListsvActivity.this,AddActivity.class);
            startActivity(intent);

        }
        if(id == R.id.thoat)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sinhvienList.clear();
        sinhvienList.addAll(dao.getALL());
        adapter.notifyDataSetChanged();

    }
}