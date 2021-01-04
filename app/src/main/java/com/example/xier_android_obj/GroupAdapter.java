package com.example.xier_android_obj;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private List<GroupBean> mGrpList;

    private boolean flag;

    public GroupAdapter(List<GroupBean> mGrpList) {
        this.mGrpList = mGrpList;
    }

    @NonNull
    @Override
    public GroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        flag = !flag;
        ViewHolder holder;
        if(flag) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_acitivity,parent,false);

            holder = new ViewHolder(view);
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_activity_right,parent,false);

            holder = new ViewHolder(view);
        }

        holder.groupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(parent.getContext(), DetailActivity.class);
                intent.putExtra("grp_imgId", (Integer) holder.imgView.getTag());
                intent.putExtra("grp_creatorName",holder.creatorName.getText().toString().trim());
                intent.putExtra("grp_groupName",holder.groupName.getText().toString().trim());
                parent.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GroupAdapter.ViewHolder holder, int position) {
        GroupBean group = mGrpList.get(position);
        holder.creatorName.setText(group.getCreater());
        holder.groupName.setText(group.getGroupName());
        holder.imgView.setImageResource(group.getImgId());
        holder.imgView.setTag(group.getImgId());//用Tag来获取Img的Id
    }

    @Override
    public int getItemCount() {
        return mGrpList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        View groupView;

        ImageView imgView;

        TextView groupName;

        TextView creatorName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            groupView = itemView;
            imgView = (ImageView) itemView.findViewById(R.id.img_group);
            groupName = (TextView) itemView.findViewById(R.id.name_group);
            creatorName = (TextView) itemView.findViewById(R.id.name_creator);
        }

    }
}
