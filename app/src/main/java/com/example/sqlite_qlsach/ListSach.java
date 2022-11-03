package com.example.sqlite_qlsach;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ListSach extends AppCompatActivity {
    private Spinner maTG;
    private EditText tenTG,tenSach,ngayXB;
    private Button btn_themSach;
    private ListView lv_sach;
    ArrayAdapter spinnerAdapter,sachAdapter;
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

        sachAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,dsSach);
        lv_sach.setAdapter(sachAdapter);

        lv_sach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListSach.this);
                alertDialogBuilder.setTitle("Xác nhận để thoát..!!!");
                alertDialogBuilder.setMessage("Bạn có muốn thoát?");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if(SachDao.Delete(ListSach.this,dsSach.get(i).getMaTG())) {
                            Toast.makeText(ListSach.this, "Delete success!", Toast.LENGTH_SHORT).show();
                            dsSach.clear();
                            dsSach.addAll(SachDao.getAllSach(ListSach.this));


                            sachAdapter.notifyDataSetChanged();

                        } else {
                            Toast.makeText(ListSach.this, "failues!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialogBuilder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Bạn đã click vào nút hủy", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return false;
            }
        });

        maTG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = maTG.getSelectedItem().toString();

                for(Sach sach : dsSach) {
                    if(sach.getMaTG().equals(item)) {
                        tenTG.setText(sach.getTenTG());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_themSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matg = maTG.getSelectedItem().toString();
                String tentg = tenTG.getText().toString();
                String tensach = tenSach.getText().toString();
                String ngayxb = ngayXB.getText().toString();
                Sach sach = new Sach(matg,tentg,tensach,ngayxb);

                SachDao.insertSach(ListSach.this,sach);
                if (SachDao.insertSach(ListSach.this,sach)) {
                    dsSach.clear();
                    dsSach.addAll(SachDao.getAllSach(ListSach.this));
                    sachAdapter.notifyDataSetChanged();
                    Toast.makeText(ListSach.this, "Add success!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListSach.this, "failues!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}