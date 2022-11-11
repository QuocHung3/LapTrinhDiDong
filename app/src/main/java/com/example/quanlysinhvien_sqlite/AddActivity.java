package com.example.quanlysinhvien_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.quanlysinhvien_sqlite.dao.SinhvienDao;
import com.example.quanlysinhvien_sqlite.model.Sinhvien;

public class AddActivity extends AppCompatActivity {
    private EditText edtht, edtns, edtlop, edtdt, edttin, edtta;
    private Button btnthem, btnthoat;
    private SinhvienDao sinhvienDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Anhxa();
        sinhvienDao = new SinhvienDao(AddActivity.this);
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtht.getText().toString();
                String namsinh = edtns.getText().toString();
                String lop = edtlop.getText().toString();
                String dt1=edtdt.getText().toString();
                String dt2=edttin.getText().toString();
                String ta1=edtta.getText().toString();
                int diemtoan,diemtin,diemta;
                diemtoan=Integer.parseInt(dt1);
                diemtin=Integer.parseInt(dt2);
                diemta=Integer.parseInt(ta1);
                Sinhvien sv = new Sinhvien(hoten,namsinh,lop,diemtoan,diemtin,diemta);
                sinhvienDao.AddSinhvien(sv);
            }
        });

    }

    private void Anhxa() {
        edtht = (EditText) findViewById(R.id.edt_hoten);
        edtns = (EditText) findViewById(R.id.edt_namsinh);
        edtlop = (EditText) findViewById(R.id.edt_lop);
        edtdt = (EditText) findViewById(R.id.edt_Diemtoan);
        edttin = (EditText) findViewById(R.id.edt_diemtin);
        edtta = (EditText) findViewById(R.id.edt_diemTA);
        btnthem = (Button) findViewById(R.id.them);
        btnthoat = (Button) findViewById(R.id.thoat);
    }
}
