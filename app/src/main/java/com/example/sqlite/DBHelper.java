package com.example.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context,"QLNV",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table NhanVien(MaNV integer primary key autoincrement,TenNV text,SoDT Text,DiaChi text)";
        sqLiteDatabase.execSQL(sql);

        sql = "insert into NhanVien values (null,'Nguyen chi Cuong','0541544445','Binh Dinh')";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into NhanVien values (null,'Nguyen Nam','0541544445','Ha Noi')";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into NhanVien values (null,'Nguyen Van nguyen','0541544445','Quang Nam')";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table if exists NhanVien");
        onCreate(sqLiteDatabase);
    }
}
