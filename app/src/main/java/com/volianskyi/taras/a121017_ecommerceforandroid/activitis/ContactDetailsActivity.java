package com.volianskyi.taras.a121017_ecommerceforandroid.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;

public class ContactDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        initViews();
    }

    private void initViews() {
        TextView tvPhone = (TextView) findViewById(R.id.tvPhoneContactDetailsActivity);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmailContactDetailsActivity);
        TextView tvAddress = (TextView) findViewById(R.id.tvAddressContactDetailsActivity);

    }
}
