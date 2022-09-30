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
    private List<The> theList;

    public theAdapter(Context context, int layout, List<The> theList) {
        this.context = context;
        this.layout = layout;
        this.theList = theList;
    }

    private class ViewHolder{
        ImageView imgThe;
        TextView tenThe;
    }

    @Override
    public int getCount() {
        return theList.size();
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
            holder.tenThe = (TextView) view.findViewById(R.id.tenThe);
            holder.imgThe = (ImageView) view.findViewById(R.id.imgThe);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        The the = theList.get(i);

        holder.tenThe.setText(the.getTenThe());
        holder.imgThe.setImageResource(the.getImgThe());


        return view;
    }








}
