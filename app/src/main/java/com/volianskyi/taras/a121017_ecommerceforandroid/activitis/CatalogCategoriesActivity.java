package com.volianskyi.taras.a121017_ecommerceforandroid.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;

public class CatalogCategoriesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_categories);
        initView();
    }

    private void initView() {
        ListView listOfCategories = (ListView)findViewById(R.id.lvCategoriesInCatelogActivity);
listOfCategories.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
