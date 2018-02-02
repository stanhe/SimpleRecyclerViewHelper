package com.stan.recyclehelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.stan.library.RecyclerView.RecyclerViewHelper;
import com.stan.library.RecyclerView.SimpleRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "MainActivity";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    List data;
    SimpleRecyclerAdapter simpleRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        // 1. init data
        data = new ArrayList(){{add("item0");add("item1");add("item2");add("item3");add("item4");}};
        // 2. set adapter and data
        simpleRecyclerAdapter = RecyclerViewHelper.INSTANCE.setupWithLinearLayoutManager(recyclerView,new SimpleRecyclerAdapter() {
            @Override
            public int setLayoutId() {
                return R.layout.item_recycler;
            }
            @Override
            public void bindItemView(View root,List data, int position) {
                TextView textView = root.findViewById(R.id.text);//get item view of root here.

                textView.setText(((String ) data.get(position)));
                textView.setTag(data.get(position));
                textView.setOnClickListener(MainActivity.this);
            }
        },data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text:
                Toast.makeText(this, ((String ) v.getTag()), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void resetData(View view) {
        data = new ArrayList(){{
            add("A");add("B");add("C");add("D");add("E");
        }};
        // 3. set data latter.
        simpleRecyclerAdapter.setData(data);
    }
}
