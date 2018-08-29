package com.walter.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
   private List<User> usersList;
   private Context mContext;

   private OnItemClickListener onItemClickListener;

    public CustomAdapter(List<User> usersList, Context mContext) {
        this.usersList = usersList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,null);
        CustomViewHolder viewHolder =new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        final User user= usersList.get(i);
        customViewHolder.tvEmail.setText(user.getEmail());
        customViewHolder.tvNames.setText(user.getNames());
        View.OnClickListener listener =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.OnItemClick(user);
            }
        };

        customViewHolder.tvNames.setOnClickListener(listener);
        customViewHolder.tvEmail.setOnClickListener(listener);

    }

    @Override
    public int getItemCount() {
        return (null!=usersList?usersList.size():0);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
         protected TextView tvNames;
         protected  TextView tvEmail;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvNames = itemView.findViewById(R.id.tvNames);
            this.tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}
