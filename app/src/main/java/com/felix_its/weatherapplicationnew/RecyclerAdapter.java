package com.felix_its.weatherapplicationnew;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {

    private List<Weather> mData;

    private LayoutInflater mInflater;

    Context mContext;

    private ItemClickListener mClickListener;


    public RecyclerAdapter(Context context, ArrayList<Weather> weather) {
        mInflater=LayoutInflater.from(context);
        this.mData=weather;
        this.mContext=context;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=mInflater.inflate(R.layout.datalistofweather,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.txtid.setText(mData.get(position).getId());
        holder.txtmain.setText(String.valueOf(mData.get(position).getMain()));
        holder.txtdesc.setText(String.valueOf(mData.get(position).getDescription()));
        holder.txticon.setText(mData.get(position).getIcon());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtid,txtmain,txtdesc,txticon;

        ImageView imgProductImage;

        ViewHolder(View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.id);
            txtmain = itemView.findViewById(R.id.main);
            txtdesc = itemView.findViewById(R.id.description);
            txticon = itemView.findViewById(R.id.weathericon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}

