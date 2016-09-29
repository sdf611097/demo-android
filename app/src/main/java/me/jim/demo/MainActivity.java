package me.jim.demo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.jim.demo.recycleViewAdapter.MyAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter myAdapter = new MyAdapter();
        mRecyclerView.addItemDecoration(new ListItemDecoration(5, 10, 15, 20));
        mRecyclerView.setAdapter(myAdapter);

    }

    class ListItemDecoration extends RecyclerView.ItemDecoration {
        int left, top, right, bottom;

        public ListItemDecoration(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {

            outRect.left = left;
            outRect.top = top;
            outRect.right = right;
            outRect.bottom = bottom;
        }
    }
}
