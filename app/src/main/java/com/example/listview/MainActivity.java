package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView;
        ArrayList<Monan> arrayList;
        Adapter_monan adapter;

        listView = findViewById(R.id.listviewmonan);
        arrayList = new ArrayList<>();
        arrayList.add(new Monan( "Bánh mì ba tê","Món ăn đường phố của Việt Nam",R.drawable.banhmi));
        arrayList.add(new Monan( "Cháo cá","Món ăn bổ dưỡng thơm ngon",R.drawable.chao));
        arrayList.add(new Monan( "Phở bò","Món ăn quen thuộc",R.drawable.pho));

        adapter = new Adapter_monan( MainActivity.this,R.layout.layout_monan, arrayList);
        listView.setAdapter(adapter);
    }
}