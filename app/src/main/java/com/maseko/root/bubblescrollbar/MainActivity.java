package com.maseko.root.bubblescrollbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trendyol.bubblescrollbarlib.BubbleScrollBar;
import com.trendyol.bubblescrollbarlib.BubbleTextProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> listData = new ArrayList<>();

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    BubbleScrollBar bubbleScrollBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);
        bubbleScrollBar = findViewById(R.id.bubbleScrollBar);

        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, linearLayoutManager.getOrientation()));

        initData();
        Collections.sort(listData);

        recyclerView.setAdapter(new Adapter(listData));
        bubbleScrollBar.attachToRecyclerView(recyclerView);
        bubbleScrollBar.setBubbleTextProvider(new BubbleTextProvider() {
            @Override
            public String provideBubbleText(int i) {
                return new StringBuilder(listData.get(i).substring(0,1)).toString();
            }
        });

    }

    public void initData(){
        listData.add("Adi");
        listData.add("Bobi");
        listData.add("Rijal");
        listData.add("Emma");
        listData.add("Irvan");
        listData.add("Hasan");
        listData.add("Tejo");
        listData.add("Pari");
        listData.add("Sabyan");
        listData.add("Diini");
    }
}
