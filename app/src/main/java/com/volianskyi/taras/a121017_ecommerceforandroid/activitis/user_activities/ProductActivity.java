package com.volianskyi.taras.a121017_ecommerceforandroid.activitis.user_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        int id = getIntent().getIntExtra("id_of_item", -1);
        TextView textView = (TextView) findViewById(R.id.tvIdOfItemProductActivity);
        textView.setText(id+" - id of our prod");
    }
}
