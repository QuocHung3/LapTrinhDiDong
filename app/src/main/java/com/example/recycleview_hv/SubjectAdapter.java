package com.example.recycleview_hv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
    private List<Subject> mSubjects;

    public void setData (List<Subject> list) {
        this.mSubjects = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subj,parent,false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = mSubjects.get(position);
        if(subject == null) {
            return;
        }

        holder.imgSubj.setImageResource(subject.getResourceID());
        holder.tvTitle.setText(subject.getTitle());
    }

    @Override
    public int getItemCount() {
        return mSubjects != null ?  mSubjects.size() :  0;
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgSubj;
        private TextView tvTitle;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSubj = itemView.findViewById(R.id.img_subj);
            tvTitle = itemView.findViewById(R.id.tv_subj);

        }
    }

}
