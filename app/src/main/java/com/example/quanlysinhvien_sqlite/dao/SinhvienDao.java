package com.example.quanlysinhvien_sqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhvien_sqlite.database.DbHelper;
import com.example.quanlysinhvien_sqlite.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class SinhvienDao {
    private DbHelper db;
    public SinhvienDao(Context context)
    {
        db = new DbHelper(context);

    }
    public List<Sinhvien>  getALL(){
        String sql="select * from Sinhvien";
        List<Sinhvien> sinhvienList = new ArrayList<Sinhvien>();
        SQLiteDatabase database=db.getReadableDatabase();
        Cursor cursor =database.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            String hoten =cursor.getString(0);
            String namsinh=cursor.getString(1);
            String lop =cursor.getString(2);
            int diemtoan=cursor.getInt(3);
            int diemtin =cursor.getInt(4);
            int diemta=cursor.getInt(5);
            Sinhvien sv = new Sinhvien(hoten,namsinh,lop,diemtoan,diemtin,diemta);
            sinhvienList.add(sv);
            cursor.moveToNext();

        }
        return  sinhvienList;


    }
    public List<Sinhvien>  getsv(String malop){
        String sql="select * from Sinhvien where lop=malop ";
        List<Sinhvien> sinhvienList = new ArrayList<Sinhvien>();
        SQLiteDatabase database=db.getReadableDatabase();
        Cursor cursor =database.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            String hoten =cursor.getString(0);
            String namsinh=cursor.getString(1);
            String lop =cursor.getString(2);
            int diemtoan=cursor.getInt(3);
            int diemtin =cursor.getInt(4);
            int diemta=cursor.getInt(5);
            Sinhvien sv = new Sinhvien(hoten,namsinh,lop,diemtoan,diemtin,diemta);
            sinhvienList.add(sv);
            cursor.moveToNext();

        }
        return  sinhvienList;


    }
    public void AddSinhvien(Sinhvien sv){
        SQLiteDatabase database=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Tensv",sv.getTensv());
        values.put("Namsinh",sv.getNamsinh());
        values.put("lop",sv.getLop());
        values.put("Diemtoan",sv.getDiemtoan());
        values.put("Diemtin",sv.getDiemtin());
        values.put("DiemTA",sv.getDiemTA());
        database.insert("Sinhvien",null,values);

    }
    public void UpdateSinhvien(Sinhvien sv){
        SQLiteDatabase database=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Tensv",sv.getTensv());
        values.put("Namsinh",sv.getNamsinh());
        values.put("lop",sv.getLop());
        values.put("Diemtoan",sv.getDiemtoan());
        values.put("Diemtin",sv.getDiemtin());
        values.put("DiemTA",sv.getDiemTA());
        String Tensv=String.valueOf(sv.getTensv());
        database.update("Sinhvien",values,"Tensv=?",new String[]{Tensv});

    }
    public int DeleteSinhvien(String masv) {
        SQLiteDatabase database = db.getWritableDatabase();
        return database.delete("Sinhvien", "Tensv=?", new String[]{masv});

    }
}
