package me.jim.demo.recycleViewAdapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.jim.demo.R;

/**
 * Created by ChunTingLin on 2016/9/10.
 */
public class MyAdapter extends RecyclerView.Adapter {

    List<ItemData> list = new ArrayList<>();

    private static int TYPE0=0;
    private static int TYPE1=1;

    public MyAdapter(){
        list.add(new ItemData("One"));
        list.add(new ItemData("Two"));
        list.add(new ItemData("3"));
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder2(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.item_title);

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.item_title);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        if(viewType==0){
            return new ViewHolder(itemLayoutView);
        }else{
            return new ViewHolder2(itemLayoutView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder){
            ViewHolder myHolder = (ViewHolder) holder;
            myHolder.textView.setText(list.get(position).getTitle());
        }else if(holder instanceof ViewHolder2){
            ViewHolder2 myHolder2 = (ViewHolder2) holder;
            myHolder2.textView.setText(list.get(position).getTitle());
            myHolder2.textView.setBackgroundColor(Color.RED);

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }
}
