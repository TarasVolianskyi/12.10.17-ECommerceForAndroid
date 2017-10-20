package com.volianskyi.taras.a121017_ecommerceforandroid.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.volianskyi.taras.a121017_ecommerceforandroid.pojo.Item;
import com.volianskyi.taras.a121017_ecommerceforandroid.adapter.MyAdapter;
import com.volianskyi.taras.a121017_ecommerceforandroid.R;

import java.util.ArrayList;

public class CatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        initView();
    }

    private void initView() {
        ListView listItemsCatalog = (ListView) findViewById(R.id.lvMainListCatalogActivity);
        ArrayList<Item> arrayList = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            Item newItem = new Item();
            newItem.setName("Product - " + i);
            newItem.setPrice("Prise - " + i * 70);
            newItem.setPrevoiusPrice("Previous price - " + i * 90);
            arrayList.add(newItem);
        }
        MyAdapter myAdapter = new MyAdapter(arrayList, this);
        listItemsCatalog.setAdapter(myAdapter);
    }
}
