package com.example.quanlysinhvien_sqlite.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhvien_sqlite.database.DbHelper;
import com.example.quanlysinhvien_sqlite.model.Lop;
import com.example.quanlysinhvien_sqlite.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class LopDao {
    private DbHelper db;
    public LopDao(Context context)
    {
        db = new DbHelper(context);

    }
    public List<Lop> getALL(){
        String sql="select * from Lop";
        List<Lop> lopList = new ArrayList<Lop>();
        SQLiteDatabase database=db.getReadableDatabase();
        Cursor cursor =database.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            String Malop =cursor.getString(0);
            String Tenlop=cursor.getString(1);
            Lop sv = new Lop(Malop,Tenlop);
            lopList.add(sv);
            cursor.moveToNext();

        }
        return  lopList;


    }

}
