package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
initViews();

    }

    private void initViews() {
        ListView listView = (ListView) findViewById(R.id.lvMainListMainActivity);
        
    }
}
