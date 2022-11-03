package com.example.sqlite_qlsach;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
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

public class ListTG extends AppCompatActivity {
    private ListView lv_tacGia;
    private ArrayAdapter adapter;
    private EditText et_suaTenTG,et_suaMaTG;
    private Button btn_xacNhanSuaTG,btn_clearSuaTGDialog;

    ArrayList<Sach> dsSach = new ArrayList<>();
    ArrayList<String> dsTTTG = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tg);

        lv_tacGia = findViewById(R.id.lv_tacGia);

        dsSach = SachDao.getAllSach(ListTG.this);
        for(Sach sach: dsSach){
            dsTTTG.add(sach.getMaTG() + " - " + sach.getTenTG());
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,dsTTTG);
        lv_tacGia.setAdapter(adapter);

        lv_tacGia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShowSuaTGDialog(i);
            }
        });

        lv_tacGia.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListTG.this);
                alertDialogBuilder.setTitle("Xác nhận để thoát..!!!");
                alertDialogBuilder.setMessage("Bạn có muốn thoát?");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if(SachDao.Delete(ListTG.this,dsSach.get(i).getMaTG())) {
                            Toast.makeText(ListTG.this, "Delete success!", Toast.LENGTH_SHORT).show();
                            dsSach.clear();
                            dsTTTG.clear();
                            dsSach.addAll(SachDao.getAllSach(ListTG.this));

                            for(Sach sach: dsSach){
                                dsTTTG.add(sach.getMaTG() + " - " + sach.getTenTG());
                            }

                            adapter.notifyDataSetChanged();

                        } else {
                            Toast.makeText(ListTG.this, "failues!", Toast.LENGTH_SHORT).show();
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
    }

    private void ShowSuaTGDialog (int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ListTG.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.sua_tgdialog,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        et_suaMaTG =  view.findViewById(R.id.et_suaMaTG);
        et_suaTenTG = view.findViewById(R.id.et_suaTenTG);
        btn_xacNhanSuaTG = view.findViewById(R.id.btn_xacNhanSuaTG);
        btn_clearSuaTGDialog = view.findViewById(R.id.btn_clear_suaTGDialog);

        Sach sach = dsSach.get(position);

        et_suaMaTG.setText(sach.getMaTG());
        et_suaTenTG.setText(sach.getTenTG());
        btn_xacNhanSuaTG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sach.setMaTG(et_suaMaTG.getText().toString());
                sach.setTenTG(et_suaTenTG.getText().toString());

                if(SachDao.Update(ListTG.this, sach)) {
                    Toast.makeText(ListTG.this, "Update success!", Toast.LENGTH_SHORT).show();
                    dsSach.clear();
                    dsTTTG.clear();
                    dsSach.addAll(SachDao.getAllSach(ListTG.this));

                    for(Sach sach: dsSach){
                        dsTTTG.add(sach.getMaTG() + " - " + sach.getTenTG());
                    }

                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                } else {
                    Toast.makeText(ListTG.this, "failues!", Toast.LENGTH_SHORT).show();
                }
            }
        });



        btn_clearSuaTGDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_suaTenTG.setText("");
                et_suaMaTG.setText("");
            }
        });
    }
}