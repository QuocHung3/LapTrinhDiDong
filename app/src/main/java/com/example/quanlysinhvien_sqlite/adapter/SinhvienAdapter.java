package com.example.quanlysinhvien_sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.quanlysinhvien_sqlite.R;
import com.example.quanlysinhvien_sqlite.model.Sinhvien;

import java.util.List;

public class SinhvienAdapter extends BaseAdapter {
    private Context context;
    private List<Sinhvien> sinhvienList;

    public SinhvienAdapter(Context context, List<Sinhvien> sinhvienList) {
        this.context = context;
        this.sinhvienList = sinhvienList;
    }

    @Override
    public int getCount() {
        return sinhvienList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder= new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.listview_svitem,null);
            viewHolder.txtten=convertView.findViewById(R.id.txt_ten);
            viewHolder.txtnamsinh=convertView.findViewById(R.id.txt_namsinh);
            viewHolder.txtlopt=convertView.findViewById(R.id.txt_lop);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder=(ViewHolder) convertView.getTag();

        }
        Sinhvien sv= sinhvienList.get(position);
        viewHolder.txtten.setText("Mã SV"  +sv.getTensv());
        viewHolder.txtnamsinh.setText("Họ tên"  +sv.getNamsinh());
        viewHolder.txtlopt.setText("SĐT"  +sv.getLop());
        return convertView;
    }
    class ViewHolder
    {

        TextView txtten,txtnamsinh,txtlopt;
    }
}
