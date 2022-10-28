package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter adapter;
    ArrayList<NhanVien> dsNV = new ArrayList<>();
    Button btnThem,btnXacNhanSua,btnXoa;
    EditText et_ten,et_soDT,etSuaTen,etSuaSoDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv_nhanvien);
        btnThem = findViewById(R.id.btnThemMoi);

        et_ten = findViewById(R.id.et_ten);
        et_soDT = findViewById(R.id.et_soDT);



        dsNV = NhanVienDao.getAll(MainActivity.this);
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,dsNV);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShowDialogSuaXoa(i);
            }
        });


       btnThem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String ten = et_ten.getText().toString();
               String so = et_soDT.getText().toString();

                if(NhanVienDao.insert(MainActivity.this,ten,so)) {
                    Toast.makeText(MainActivity.this, "Add success!", Toast.LENGTH_SHORT).show();
                    dsNV.clear();
                    dsNV.addAll(NhanVienDao.getAll(MainActivity.this));
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Add failues!", Toast.LENGTH_SHORT).show();
                }
           }
       });
    }

    private void ShowDialogSuaXoa (int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.update_dialog,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        etSuaTen =  view.findViewById(R.id.et_suaTen);
        etSuaSoDT = view.findViewById(R.id.et_suaSoDT);
        btnXacNhanSua = view.findViewById(R.id.btn_xacnhan_sua);
        btnXoa = view.findViewById(R.id.btn_xoa);

        NhanVien nv = dsNV.get(position);

        etSuaTen.setText(nv.getTenNV());
        etSuaSoDT.setText(nv.getSoDT());
        btnXacNhanSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nv.setTenNV(etSuaTen.getText().toString());
                nv.setSoDT(etSuaSoDT.getText().toString());

                if(NhanVienDao.Update(MainActivity.this, nv)) {
                    Toast.makeText(MainActivity.this, "Update success!", Toast.LENGTH_SHORT).show();
                    dsNV.clear();
                    dsNV.addAll(NhanVienDao.getAll(MainActivity.this));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "failues!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(NhanVienDao.Delete(MainActivity.this,nv.getMaNV())) {
                    Toast.makeText(MainActivity.this, "Delete success!", Toast.LENGTH_SHORT).show();
                    dsNV.clear();
                    dsNV.addAll(NhanVienDao.getAll(MainActivity.this));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "failues!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}