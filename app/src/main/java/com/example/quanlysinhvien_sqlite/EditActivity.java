package com.example.quanlysinhvien_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlysinhvien_sqlite.dao.SinhvienDao;
import com.example.quanlysinhvien_sqlite.model.Sinhvien;

public class EditActivity extends AppCompatActivity {
    private EditText edtht, edtns, edtlop, edtdt, edttin, edtta,edttb;
    private Button btnthem, btnthoat;
    private SinhvienDao sinhvienDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        sinhvienDao = new SinhvienDao(EditActivity.this);
        Intent intent=getIntent();
        Sinhvien sinhvien= (Sinhvien) intent.getSerializableExtra("Dulieu");
        edtht.setText(sinhvien.getTensv());
        edtdt.setText(sinhvien.getDiemtoan());
        edtns.setText(sinhvien.getNamsinh());
        edtlop.setText(sinhvien.getLop());
        edttin.setText(sinhvien.getDiemtin());
        edtta.setText(sinhvien.getDiemTA());
        edttb.setText(sinhvien.dtb());

        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sinhvien sv =new Sinhvien();
                sv.setTensv(edtht.getText().toString());
                sv.setNamsinh(edtns.getText().toString());
                sv.setLop(edtlop.getText().toString());
                String dt1=edtdt.getText().toString();
                String dt2=edttin.getText().toString();
                String ta1=edtta.getText().toString();
                int diemtoan,diemtin,diemta;
                diemtoan=Integer.parseInt(dt1);
                diemtin=Integer.parseInt(dt2);
                diemta=Integer.parseInt(ta1);

                sinhvienDao.UpdateSinhvien(sv);
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
        btnthem = (Button) findViewById(R.id.luu);
        btnthoat = (Button) findViewById(R.id.thoat);
        edttb =(EditText) findViewById(R.id.edt_diemTb);
    }
}

