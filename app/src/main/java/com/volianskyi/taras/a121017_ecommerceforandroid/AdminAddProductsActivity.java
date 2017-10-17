package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminAddProductsActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNameOfNewItemFromAdmin;
    EditText etPriceOfNewItemFromAdmin;
    EditText etSaleOfItemInPersent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_products);
        initView();
    }

    private void initView(){
        Button btnAdd = (Button) findViewById(R.id.btnAddNewAdminAddProductsActivity);
        btnAdd.setOnClickListener(this);
        etNameOfNewItemFromAdmin = (EditText) findViewById(R.id.etNameAdminAddProductsActivity);
        etPriceOfNewItemFromAdmin = (EditText) findViewById(R.id.etPriceAdminAddProductsActivity);

    }

    @Override
    public void onClick(View view) {
        String nameOfNewUser = etNameOfNewItemFromAdmin.getText().toString();
        String passOfNewUser = etPriceOfNewItemFromAdmin.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME_PRODUCTS_TABLE, nameOfNewUser);
        contentValues.put(DatabaseHelper.PRICE_PRODUCTS_TABLE, passOfNewUser);
        getContentResolver().insert(DatabaseHelper.URI_PRODUCTS, contentValues);
        startActivity(new Intent(AdminAddProductsActivity.this, AdminProductsActivity.class));
    }
}
