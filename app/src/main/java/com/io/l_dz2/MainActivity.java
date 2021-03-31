package com.io.l_dz2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        private RecyclerView mRecyclerView;
        private RecyclerViewAdapter mAdapter;
        private List<String> mList = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initView();
        }

        private void initView() {
            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            for (int i = 0; i < 11; i++) {
                mList.add("Loh" + " "+ "Sasi " + i);
            }

            LinearLayoutManager mManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(mManager);
            mAdapter = new RecyclerViewAdapter(MainActivity.this, mList);
            mRecyclerView.setAdapter(mAdapter);
    }
}