package com.dimas.pizzarecipes;

import android.content.Context;
import android.content.Intent;
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
    Context context;

    public class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imView;
        public TextView text1;
        public TextView text2;

        public RecyclerViewViewHolder (@NonNull View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            imView = itemView.findViewById(R.id.imView);
            text1 = itemView.findViewById(R.id.tvHead);
            text2 = itemView.findViewById(R.id.tvBody);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            RecycleViewItem recycleViewItem = arrayList.get(position);

            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra("imRes", recycleViewItem.getImageRes());
            intent.putExtra("tvTitle", recycleViewItem.getText1());
            intent.putExtra("tvDesc", recycleViewItem.getText2());
            context.startActivity(intent);
        }
    }

    public RecycleViewAdapter(ArrayList<RecycleViewItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  {
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
