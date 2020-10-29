package com.android.xg.elabtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyLerviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rv);

        List<String> mData = new ArrayList<>();
        mData.add("1");
        mData.add("2");
        mData.add("3");
        mData.add("4");
        mData.add("5");
        mData.add("6");
        /*mData.add("7");
        mData.add("8");
        mData.add("9");
        mData.add("10");
        mData.add("11");
        mData.add("12");
        mData.add("13");
        mData.add("14");
        mData.add("15");
        mData.add("16");
        mData.add("17");*/


        RecyclerView rv = findViewById(R.id.rv);
        //rv.addItemDecoration(new SpaceItemDecoration(5));
        MyAdapter adapter = new MyAdapter(mData);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                }
                return 1;

            }
        });


        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(adapter);
    }


    class MyAdapter extends RecyclerView.Adapter {

        private List<String> mDatas;

        class ViewHolder extends RecyclerView.ViewHolder {
            AppCompatTextView tv;

            public ViewHolder(View view) {
                super(view);
                tv = view.findViewById(R.id.tv);
            }
        }

        public MyAdapter(List<String> mDatas) {
            this.mDatas = mDatas;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.tv.setText(mDatas.get(position));


        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
    }
}
