package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_monan extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Monan> arraylist;

    public Adapter_monan(Context context, int layout, List<Monan> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }



    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        Monan monan = arraylist.get(position);

        TextView text1 = view.findViewById(R.id.name);
        TextView text2 = view.findViewById(R.id.mota);
        ImageView imageV = view.findViewById(R.id.imageHinh);

        text1.setText(monan.getTenmon());
        text2.setText(monan.getMota());
        imageV.setImageResource(monan.getHinh());

        return view;
    }
}
