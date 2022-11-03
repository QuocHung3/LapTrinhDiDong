package com.example.sqlite_qlsach;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context,"QLSach",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table Sach(STT integer primary key autoincrement,MaTG text,TenTG text,TenSach text,NgayXB text)";
        sqLiteDatabase.execSQL(sql);

        sql = "insert into Sach values (null,'tg01','Nguyen chi Cuong','Mot thoi de nho','02-07-2002')";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Sach values (null,'tg02','Nguyen Nam','De men phieu luu ki','05-06-2001')";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Sach values (null,'tg03','Nguyen Van nguyen','lam di','09-12-2011')";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table if exists Sach");
        onCreate(sqLiteDatabase);
    }
}
