package com.example.sqlite_qlsv.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "QLSinhVien.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlSVCreate = "CREATE TABLE IF NOT EXISTS SinhVien(" +
                "MaSV integer primary key autoincrement," +
                "HoTen text," +
                "GioiTinh integer," +
                "DienThoai text," +
                "Email text)";
        sqLiteDatabase.execSQL(sqlSVCreate);
        String sqlInsert = "insert into SinhVien (HoTen,GioiTinh,DienThoai,Email) Values('Nong Quoc Hung','1','089454','mail@gmail.com')";
        String sqlInsert1 = "insert into SinhVien (HoTen,GioiTinh,DienThoai,Email) Values('Tun','1','089454','mail@gmail.com')";
        String sqlInsert2= "insert into SinhVien (HoTen,GioiTinh,DienThoai,Email) Values('Ti','0','089454','mail@gmail.com')";
        sqLiteDatabase.execSQL(sqlInsert);
        sqLiteDatabase.execSQL(sqlInsert1);
        sqLiteDatabase.execSQL(sqlInsert2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
