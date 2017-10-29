package com.volianskyi.taras.a121017_ecommerceforandroid.activitis;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;
import com.volianskyi.taras.a121017_ecommerceforandroid.adapter.MyAdapter;
import com.volianskyi.taras.a121017_ecommerceforandroid.adapter.MyAdapterRecyclerView;
import com.volianskyi.taras.a121017_ecommerceforandroid.database.DatabaseHelper;
import com.volianskyi.taras.a121017_ecommerceforandroid.pojo.Item;

import java.util.ArrayList;

public class Catalog2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog2);
        initView();
    }

    private void initView() {
        RecyclerView rvItemsCatalog = (RecyclerView) findViewById(R.id.rvCatalog2Activity);
        rvItemsCatalog.setLayoutManager(new LinearLayoutManager(this));
        rvItemsCatalog.setAdapter(new MyAdapterRecyclerView(getData(), this));
    }

    private ArrayList<String> getData() {
        ArrayList<String> arrayList = new ArrayList<>();
        DatabaseHelper helper = new DatabaseHelper(this, 1);
        SQLiteDatabase dataBase = helper.getWritableDatabase();
        Cursor cursor = dataBase.query(DatabaseHelper.CATEGORIES_TABLE_NAME, null, null, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            arrayList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.NAME_CATEGORIES_TABLE)));
        } while (cursor.moveToNext());
        return arrayList;
    }
}
