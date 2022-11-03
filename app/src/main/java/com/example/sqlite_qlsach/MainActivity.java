package com.example.sqlite_qlsach;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_themTG,btn_xemTG,btn_qlSach;
    private Button btn_clearThemTGDialog,btn_XacNhanThemTG;
    private EditText etThemMaTG,etThemTenTG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_themTG = findViewById(R.id.btn_themTG);
        btn_xemTG = findViewById(R.id.btn_xemTG);
        btn_qlSach = findViewById(R.id.btn_qlSach);

        btn_themTG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowThemTGDialog();
            }
        });

        btn_xemTG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListTG.class);
                startActivity(intent);
            }
        });

        btn_qlSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListSach.class);
                startActivity(intent);
            }
        });
    }

    private void ShowThemTGDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.them_tgdialog, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();


        etThemMaTG = view.findViewById(R.id.et_themMaTG);
        etThemTenTG = view.findViewById(R.id.et_themTenTG);
        btn_clearThemTGDialog = view.findViewById(R.id.btn_clear_themTGDialog);
        btn_XacNhanThemTG = view.findViewById(R.id.btn_xacNhanThemTG);


        btn_XacNhanThemTG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SachDao.insert(MainActivity.this, etThemMaTG.getText().toString(),etThemTenTG.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Update success!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "failues!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_clearThemTGDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etThemMaTG.setText("");
                etThemTenTG.setText("");
            }
        });
    }


}