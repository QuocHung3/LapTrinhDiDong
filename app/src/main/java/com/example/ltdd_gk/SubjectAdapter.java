package com.example.ltdd_gk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class SubjectAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Subject> subjectList;

    private class ViewHolder{
        ImageView img_lv_item;
        TextView name_lv_item,desc_lv_item;
    }

    public SubjectAdapter(Context context, int layout, List<Subject> subjectList) {
        this.context = context;
        this.layout = layout;
        this.subjectList = subjectList;
    }

    @Override
    public int getCount() {
        return subjectList.size();
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
            holder.name_lv_item = (TextView) view.findViewById(R.id.name_lv_item);
            holder.desc_lv_item = (TextView) view.findViewById(R.id.desc_lv_item);
            holder.img_lv_item = (ImageView) view.findViewById(R.id.img_lv_item);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Subject subject = subjectList.get(i);

        holder.name_lv_item.setText(subject.getName());

        if(subject.getDesc().length() >= 20) {
            String subString = subject.getDesc().toString().substring(0,20) + "..." ;
            holder.desc_lv_item.setText(subString);
        } else {
            holder.desc_lv_item.setText(subject.getDesc());
        }
        holder.img_lv_item.setImageResource(subject.getImg());


        return view;
    }
}
