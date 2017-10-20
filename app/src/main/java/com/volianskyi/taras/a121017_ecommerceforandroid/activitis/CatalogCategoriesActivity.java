package com.volianskyi.taras.a121017_ecommerceforandroid.activitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;

public class CatalogCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_categories);
        getSupportActionBar().setTitle("Categories of Products");
        initView();
    }

    private void initView() {
        ListView listOfCategories = (ListView) findViewById(R.id.lvCategoriesInCatelogActivity);
        final String[] arrayCategoryList = getResources().getStringArray(R.array.arrayCategoriesOfProducts);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayCategoryList);
        listOfCategories.setAdapter(arrayAdapter);
        listOfCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CatalogCategoriesActivity.this, "Your choise is - " + arrayCategoryList[i], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CatalogCategoriesActivity.this, CatalogActivity.class);
                intent.putExtra("NumberOfCategory" ,l);
                startActivity(intent);
            }
        });
    }
}