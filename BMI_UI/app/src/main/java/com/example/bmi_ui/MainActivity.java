package com.example.bmi_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cc,cn;
    Button result;
    TextView ketqua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cc = (EditText) findViewById(R.id.cc);
        cn = (EditText) findViewById(R.id.cn);
        result = (Button) findViewById(R.id.result);
        ketqua = (TextView) findViewById(R.id.ketqua);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cc.getText().toString().equals("") || cn.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this,"Nhập tất cả các chỉ số!",Toast.LENGTH_SHORT).show();
                    return;
                }

                double height = Double.valueOf(cc.getText().toString().trim());
                double weight = Double.valueOf(cn.getText().toString().trim());

                double rs = weight/(height*height);


                if(rs < 18) {
                    ketqua.setText("Người gầy");
                } else if(rs >=18 && rs < 25) {
                    ketqua.setText("Người bình thường");
                }   else if(rs >=25 && rs < 30) {
                    ketqua.setText("Người béo cấp I");
                } else if(rs >= 30 && rs < 40) {
                    ketqua.setText("Người béo cấp II");
                }  else {
                    ketqua.setText("Người béo cấp III");
                }

            }
        });
    }
}