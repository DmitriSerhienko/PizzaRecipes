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

    private final ArrayList <RecycleViewItem> arrayList;
    Context context;

    public class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imView;
        public TextView text1;
        public TextView text2;

        public RecyclerViewViewHolder (@NonNull final View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            this.imView = itemView.findViewById(R.id.imView);
            this.text1 = itemView.findViewById(R.id.tvHead);
            this.text2 = itemView.findViewById(R.id.tvBody);
        }

        @Override
        public void onClick(final View view) {
            final int position = this.getAdapterPosition();
            final RecycleViewItem recycleViewItem = RecycleViewAdapter.this.arrayList.get(position);

            final Intent intent = new Intent(RecycleViewAdapter.this.context, RecipeActivity.class);
            intent.putExtra("imRes", recycleViewItem.getImageRes());
            intent.putExtra("tvTitle", recycleViewItem.getText1());
            intent.putExtra("tvDesc", recycleViewItem.getText2());
            RecycleViewAdapter.this.context.startActivity(intent);
        }
    }

    public RecycleViewAdapter(final ArrayList<RecycleViewItem> arrayList, final Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType)  {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_view_item,
                parent, false);
        final RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewViewHolder holder, final int position) {
        final RecycleViewItem recycleViewItem = this.arrayList.get(position);

        holder.imView.setImageResource(recycleViewItem.getImageRes());
        holder.text1.setText(recycleViewItem.getText1());
        holder.text2.setText(recycleViewItem.getText2());
    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }
}
