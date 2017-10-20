package com.volianskyi.taras.a121017_ecommerceforandroid.activitis;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.volianskyi.taras.a121017_ecommerceforandroid.database.DatabaseHelper;
import com.volianskyi.taras.a121017_ecommerceforandroid.R;

public class AdminUpdateProductsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvID;
    private TextView tvName;
    private TextView tvPrice;
    private TextView tvCategory;
    private EditText etName;
    private EditText etPrice;
    private Spinner spinnerOfCatogies;
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
        spinnerView();
    }

    private void spinnerView() {
        spinnerOfCatogies = (Spinner) findViewById(R.id.spinnerOfCatogiesAdminUpdateProductsActivity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arrayCategoriesOfProducts, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOfCatogies.setAdapter(adapter);
        spinnerOfCatogies.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AdminUpdateProductsActivity.this, "selected - " + l, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdateAdminUpdateProductsActivity:
                String nameProduct = etName.getText().toString();
                String priceProduct = etPrice.getText().toString();
                String categoryProduct = spinnerOfCatogies.getSelectedItem().toString();
                ContentValues contentValuesUpdateProduct = new ContentValues();
                contentValuesUpdateProduct.put(DatabaseHelper.NAME_PRODUCTS_TABLE, nameProduct);
                contentValuesUpdateProduct.put(DatabaseHelper.PRICE_PRODUCTS_TABLE, priceProduct);
                contentValuesUpdateProduct.put(DatabaseHelper.CATEGORY_PRODUCTS_TABLE, categoryProduct);
                getContentResolver().update(DatabaseHelper.URI_PRODUCTS, contentValuesUpdateProduct, DatabaseHelper.ID_PRODUCTS_TABLE + "=?", new String[]{"" + (numberOfProductFromList) + ""});
                Toast.makeText(this, "" + numberOfProductFromList + "name - " + nameProduct + " price - " + priceProduct, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminUpdateProductsActivity.this, AdminProductsActivity.class));
                break;
            case R.id.btnDeleteAdminUpdateProductsActivity:
                getContentResolver().delete(DatabaseHelper.URI_PRODUCTS, DatabaseHelper.ID_PRODUCTS_TABLE + "=?", new String[]{"" + (numberOfProductFromList)});
                startActivity(new Intent(AdminUpdateProductsActivity.this, AdminProductsActivity.class));
                break;
        }
    }
}
