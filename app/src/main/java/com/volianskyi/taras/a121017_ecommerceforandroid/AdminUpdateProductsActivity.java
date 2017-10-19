package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminUpdateProductsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvID;
    private TextView tvName;
    private TextView tvPrice;
    private TextView tvCategory;
    private EditText etName;
    private EditText etPrice;
    private long numberOfProductFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_products);
         initView();
    }

    private void initView() {
        numberOfProductFromList = getIntent().getLongExtra("NumberOfProductFromList", 0);
        tvID = (TextView) findViewById(R.id.tvIDAdminUpdateProductsActivity);
        tvName = (TextView) findViewById(R.id.tvNameAdminUpdateProductsActivity);
        tvPrice = (TextView) findViewById(R.id.tvPriceAdminUpdateProductsActivity);
        tvCategory = (TextView) findViewById(R.id.tvCategoryAdminUpdateProductsActivity);
        etName = (EditText) findViewById(R.id.etNameAdminUpdateProductsActivity);
        etPrice = (EditText) findViewById(R.id.etPriceAdminUpdateProductsActivity);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdateAdminUpdateProductsActivity);
        Button btnDelete = (Button) findViewById(R.id.btnDeleteAdminUpdateProductsActivity);
        tvID.setText("ID - " + numberOfProductFromList);
        tvName.setText("Name - " + numberOfProductFromList);
        tvPrice.setText("Price - " + numberOfProductFromList);
        tvCategory.setText("Category - " + numberOfProductFromList);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdateAdminUpdateProductsActivity:
                String nameUser = etName.getText().toString();
                String passUser = etPrice.getText().toString();
                ContentValues contentValuesUpdateUsers = new ContentValues();
                contentValuesUpdateUsers.put(DatabaseHelper.NAME_PRODUCTS_TABLE, "test");
                contentValuesUpdateUsers.put(DatabaseHelper.PRICE_PRODUCTS_TABLE, "trstr2");
                getContentResolver().update(DatabaseHelper.URI_PRODUCTS, contentValuesUpdateUsers, DatabaseHelper.ID_PRODUCTS_TABLE + "=?", new String[]{"" + numberOfProductFromList});
                Toast.makeText(this, "" + numberOfProductFromList + "name - " + nameUser + " pass - " + passUser, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminUpdateProductsActivity.this, AdminProductsActivity.class));
                break;
            case R.id.btnDeleteAdminUpdateProductsActivity:
                getContentResolver().delete(DatabaseHelper.URI_USERS, DatabaseHelper.ID_USERS_TABLE + "=?", new String[]{"" + numberOfProductFromList});
                startActivity(new Intent(AdminUpdateProductsActivity.this, AdminProductsActivity.class));
                break;
        }
    }
}
