package com.example.ltdd_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class theAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TacGia> tgList;

    public theAdapter(Context context, int layout, List<TacGia> theList) {
        this.context = context;
        this.layout = layout;
        this.tgList = theList;
    }

    private class ViewHolder{
        ImageView imgTG;
        TextView tenTG,motaTG;
    }

    @Override
    public int getCount() {
        return tgList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);

            holder =new ViewHolder();
            holder.tenTG = (TextView) view.findViewById(R.id.tenThe);
            holder.motaTG = (TextView) view.findViewById(R.id.motaThe);
            holder.imgTG = (ImageView) view.findViewById(R.id.imgThe);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        TacGia the = tgList.get(i);

        holder.tenTG.setText(the.getTenTG());

        if (the.getMotaTG().length() >= 20) {
            String desc = the.getMotaTG().substring(0,25) + "...";
            holder.motaTG.setText(desc);
        }

        holder.imgTG.setImageResource(the.getImgTG());


        return view;
    }








}
