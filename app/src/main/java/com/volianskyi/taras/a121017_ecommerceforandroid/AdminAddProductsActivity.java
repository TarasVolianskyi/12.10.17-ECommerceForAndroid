package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdminAddProductsActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private EditText etNameOfNewItemFromAdmin;
    private EditText etPriceOfNewItemFromAdmin;
    private EditText etSaleOfItemInPersent;
    private Bundle bundle = new Bundle();
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_products);
        initView();
    }

    private void initView() {
        Button btnAdd = (Button) findViewById(R.id.btnAddNewAdminAddProductsActivity);
        btnAdd.setOnClickListener(this);
        etNameOfNewItemFromAdmin = (EditText) findViewById(R.id.etNameAdminAddProductsActivity);
        etPriceOfNewItemFromAdmin = (EditText) findViewById(R.id.etPriceAdminAddProductsActivity);
        spinnerView();
        initCheckBoxes();
    }

    private void spinnerView() {
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arrayCategoriesOfProducts, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AdminAddProductsActivity.this, "selected - " + l, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initCheckBoxes() {
        ((CheckBox) findViewById(R.id.cbIsSaleAdminAddProductsActivity)).setOnCheckedChangeListener(this);
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

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        bundle.putBoolean("RadioGroup", b);

        if (b) {
            findViewById(R.id.spinner).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.spinner).setVisibility(View.GONE);
        }
    }
}
