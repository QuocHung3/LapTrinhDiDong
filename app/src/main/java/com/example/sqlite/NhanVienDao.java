package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NhanVienDao {
    public static ArrayList<NhanVien> getAll(Context context) {
        ArrayList<NhanVien> ds = new ArrayList<>();

        DBHelper dbHelper= new DBHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from NhanVien",null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            int ma = cursor.getInt(0);
            String ten = cursor.getString(1);
            String sodt = cursor.getString(2);
            String diachi = cursor.getString(3);

            NhanVien nv = new  NhanVien(ma,ten,sodt,diachi);

            ds.add(nv);
            cursor.moveToNext();
        }
        cursor.close();
        dbHelper.close();
        return ds;
    }

    public  static boolean insert(Context context,String ten,String soDT) {
        DBHelper dbHelper= new DBHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenNV",ten);
        values.put("SoDT",soDT);

        long row = db.insert("NhanVien",null,values);

        return (row>0);
    }

    public  static boolean Update(Context context,NhanVien nv) {
        DBHelper dbHelper= new DBHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenNV",nv.getTenNV());
        values.put("SoDT",nv.getSoDT());

        int row = db.update("NhanVien",values,"MaNV = ?",new String[]{nv.getMaNV()+""});

        return (row>0);
    }

    public static boolean Delete (Context context,int maNV) {
        DBHelper dbHelper= new DBHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        int row= db.delete("NhanVien","MaNV = ?",new String[]{maNV + ""});

        return (row>0);
    }

}
