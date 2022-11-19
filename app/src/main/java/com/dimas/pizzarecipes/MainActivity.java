package com.dimas.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<RecycleViewItem> recycleViewItem = new ArrayList<>();
        recycleViewItem.add(new RecycleViewItem(R.drawable.b1, "Волынский борщ", "При подаче готовое блюдо украсьте свежей зеленью."));
        recycleViewItem.add(new RecycleViewItem(R.drawable.b2, "Галыцкий борщ", "Борщ придется по душе тем, кто склонен к диетам – т.к. готовится без мяса."));
        recycleViewItem.add(new RecycleViewItem(R.drawable.b3, "Донецкий борщ", "Традиционно такой борщ особенно хорош с черным хлебом, а не с привычными пампушками с чесноком, именно это и отличает его от других вариаций украинских борщей."));
        recycleViewItem.add(new RecycleViewItem(R.drawable.b4, "Зеленый борщ по-украински", "При подаче на стол щедро посыпьте порцию мелко шинкованной зеленью, зеленым луком, добавьте в тарелку половинку сваренного вкрутую яйца. Приятного аппетита!"));
        recycleViewItem.add(new RecycleViewItem(R.drawable.b5, "Борщ киевский", "Отдельно поджарьте на сале сосиски, предварительно нарезанные кружочками. Добавьте их в готовый борщ после того, как выключите его."));


        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        adapter = new RecycleViewAdapter(recycleViewItem);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }


}