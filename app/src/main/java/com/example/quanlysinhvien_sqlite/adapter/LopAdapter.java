package com.example.quanlysinhvien_sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlysinhvien_sqlite.R;
import com.example.quanlysinhvien_sqlite.model.Lop;
import com.example.quanlysinhvien_sqlite.model.Sinhvien;

import java.util.List;

public class LopAdapter extends BaseAdapter {
    private Context context;
    private List<Lop> lopList;

    public LopAdapter(Context context, List<Lop> lopList) {
        this.context = context;
        this.lopList = lopList;
    }

    @Override
    public int getCount() {
        return lopList.size();
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
            viewHolder= new LopAdapter.ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.listvew_lopitem,null);
            viewHolder.txtmalop=convertView.findViewById(R.id.txt_malop);
            viewHolder.txttenlop=convertView.findViewById(R.id.txt_tenlop);


            convertView.setTag(viewHolder);

        }
        else {
            viewHolder=(LopAdapter.ViewHolder) convertView.getTag();

        }
        Lop lop= lopList.get(position);
        viewHolder.txtmalop.setText("Mã Lớp:     "  +lop.getMalop());
        viewHolder.txttenlop.setText("Tên lớp:    "  +lop.getTenlop());


        return convertView;
    }

    class ViewHolder{
        TextView txtmalop,txttenlop;

    }
}
