package com.example.viewwithattrpractice;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PavilionAreaAdapter  extends  RecyclerView.Adapter<PavilionAreaAdapter.PavilionAreaViewHolder>{
    private  Context mContext;
    private List<PavilionArea> pavilionAreas;

    public PavilionAreaAdapter(Context context, List<PavilionArea> pavilionAreas) {
        this.mContext = context;
        this.pavilionAreas = pavilionAreas;
    }

    @NonNull
    @Override
    public PavilionAreaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                        .inflate(R.layout.component_imgtextview,parent,false);
        return new PavilionAreaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PavilionAreaViewHolder holder, int position) {
        PavilionArea pavilionArea = pavilionAreas.get(position);
        holder.setData(pavilionArea);
    }

    @Override
    public int getItemCount() {
        return pavilionAreas.size();
    }

    public class PavilionAreaViewHolder extends RecyclerView.ViewHolder{

        private final ImageView mPailionPic;
        private final TextView mMPailionName;
        private final TextView mPailionInfo;
        private final TextView mPailionMemo;

        public PavilionAreaViewHolder(@NonNull View itemView) {
            super(itemView);
            mPailionPic = itemView.findViewById(R.id.img);
            mMPailionName = itemView.findViewById(R.id.txt);
            mPailionInfo = itemView.findViewById(R.id.txt_describe);
            mPailionMemo = itemView.findViewById(R.id.memo_text);
        }

        public void setData(PavilionArea pavilionArea) {
            mPailionPic.setImageURI(Uri.parse(pavilionArea.getE_pic_url()));
            mMPailionName.setText(pavilionArea.getE_name());
            mPailionInfo.setText(pavilionArea.getE_Info());
            mPailionMemo.setText(pavilionArea.getE_memo());

        }
    }
}
