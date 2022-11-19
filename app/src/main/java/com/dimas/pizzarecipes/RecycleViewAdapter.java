package com.dimas.pizzarecipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecyclerViewViewHolder> {

    private ArrayList <RecycleViewItem> arrayList;

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder{
        public ImageView imView;
        public TextView text1;
        public TextView text2;

        public RecyclerViewViewHolder (@NonNull View itemView){
            super(itemView);
            imView = itemView.findViewById(R.id.imView);
            text1 = itemView.findViewById(R.id.tvHead);
            text2 = itemView.findViewById(R.id.tvBody);
        }
    }

    public RecycleViewAdapter(ArrayList<RecycleViewItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_view_item,
                parent, false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        RecycleViewItem recycleViewItem = arrayList.get(position);

        holder.imView.setImageResource(recycleViewItem.getImageRes());
        holder.text1.setText(recycleViewItem.getText1());
        holder.text2.setText(recycleViewItem.getText2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
