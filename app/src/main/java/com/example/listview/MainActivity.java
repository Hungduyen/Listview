package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.nio.file.Path;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Monan> arrayList;
    Adapter_monan adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = findViewById(R.id.listviewmonan);
        arrayList = new ArrayList<>();
        arrayList.add(new Monan( "Bánh mì ba tê","Món ăn đường phố của Việt Nam",R.drawable.banhmi));
        arrayList.add(new Monan( "Cháo cá","Món ăn bổ dưỡng thơm ngon",R.drawable.chao));
        arrayList.add(new Monan( "Phở bò","Món ăn quen thuộc",R.drawable.pho));

        adapter = new Adapter_monan( MainActivity.this,R.layout.layout_monan, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,MainActivity3.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,MainActivity4.class);
                    startActivity(intent);
                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {

                deleteData(position);
                return false;
            }
        });
    }
    private void deleteData(int position){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Delete")
                        .setMessage("Bạn có muốn xóa k?")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        arrayList.remove(position);
                                        adapter.notifyDataSetChanged();
                                    }
                                }).setNegativeButton("Cancel",null)
                .show();

    }
}