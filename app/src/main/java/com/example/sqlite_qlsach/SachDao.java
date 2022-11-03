package com.example.sqlite_qlsach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class SachDao {
    public static ArrayList<Sach> getAllSach(Context context) {
        ArrayList<Sach> dsSach = new ArrayList<>();

        DBHelper dbHelper= new DBHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Sach",null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            String maTG = cursor.getString(0);
            String tenTG = cursor.getString(1);
            String tenSach = cursor.getString(2);
            String ngayXB = cursor.getString(3);

            Sach sach = new Sach(maTG,tenTG,tenSach,ngayXB);

            dsSach.add(sach);
            cursor.moveToNext();
        }
        cursor.close();
        dbHelper.close();
        return dsSach;
    }

    public  static boolean insert(Context context,String maTG,String tenTG) {
        DBHelper dbHelper= new DBHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaTG",maTG);
        values.put("TenTG",tenTG);

        long row = db.insert("Sach",null,values);

        return (row>0);
    }

    public  static boolean Update(Context context,Sach sach) {
        DBHelper dbHelper= new DBHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaTG",sach.getMaTG());
        values.put("TenTG",sach.getTenTG());

        int row = db.update("Sach",values,"MaTG = ?",new String[]{sach.getMaTG()+""});

        return (row>0);
    }

    public static boolean Delete (Context context,String maTG) {
        DBHelper dbHelper= new DBHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        int row= db.delete("Sach","maTG = ?",new String[]{maTG + ""});

        return (row>0);
    }
}
