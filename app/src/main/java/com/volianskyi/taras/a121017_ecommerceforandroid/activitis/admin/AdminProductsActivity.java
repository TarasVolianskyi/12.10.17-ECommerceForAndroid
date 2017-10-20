package com.volianskyi.taras.a121017_ecommerceforandroid.activitis.admin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.volianskyi.taras.a121017_ecommerceforandroid.database.DatabaseHelper;
import com.volianskyi.taras.a121017_ecommerceforandroid.R;

public class AdminProductsActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_products);
       // getSupportActionBar().setTitle("Products - Admain page");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initFAB();
        initView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.lvProductsAdminContent);
        Cursor cursor = getContentResolver().query(DatabaseHelper.URI_PRODUCTS, null, null, null, null, null);
        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor,
                new String[]{DatabaseHelper.NAME_PRODUCTS_TABLE, DatabaseHelper.CATEGORY_PRODUCTS_TABLE},
                new int[]{android.R.id.text1, android.R.id.text2}, Adapter.NO_SELECTION);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AdminProductsActivity.this, "You click at number " + l, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminProductsActivity.this, AdminUpdateProductsActivity.class);
                intent.putExtra("NumberOfProductFromList", l);
                startActivity(intent);
            }
        });
    }

    private void initFAB() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminProductsActivity.this, "Go to Add Products", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminProductsActivity.this, AdminAddProductsActivity.class));
            }
        });
    }

}
