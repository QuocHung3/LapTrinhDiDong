package com.example.quanlysinhvien_sqlite.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper( Context context) {
        super(context, "QLSinhvien1.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreatelop ="Create table Lop(Malop nvarchar(50) primary key,Tenlop nvarchar(200) )";
         db.execSQL(sqlCreatelop);
         String sqlCreatesv="Create table Sinhvien(Tensv nvarchar(200) primary key,Namsinh nvarchar(200),lop nvarchar50 ,Diemtoan int,Diemtin int,DiemTA int,foreign key (lop) references Lop(Malop)  )";
         db.execSQL(sqlCreatesv);
         String insertlop="Insert into Lop values('ML01','Lớp 20T1'),('ML02','Lớp 20T2')";
         db.execSQL(insertlop);
         String insertsv="Insert into Sinhvien values('Nguyễn Minh Danh','2002','ML01',8,9,10),('Nguyễn Văn A','2003','ML02',6,7,8)";
          db.execSQL(insertsv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
